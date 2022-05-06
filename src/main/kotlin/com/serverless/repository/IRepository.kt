package com.serverless.repository

import com.serverless.exceptions.BadConnectionException
import com.serverless.models.CharityOrganization
import com.serverless.models.User
import com.serverless.utils.DbUtil
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource
import org.springframework.jdbc.support.GeneratedKeyHolder

interface IRepository<T> {
    fun add(entity: T): Int?
    fun delete(id: String?)
    fun update(entity: T): Int?
    fun get(id: String?): T?
    fun getAll(): List<T>
    fun getAllWithConditions(params: Map<String, String>): List<T>
    fun exists(params: Map<String, String>): Int
}

abstract class Repository<T>(private val dbUtil: DbUtil, private val cl : Class<T>, private val table : String = cl.simpleName) : IRepository<T> {
    private val jdbcTemplate = this.dbUtil.NAMED_JDBC_TEMPLATE ?: throw BadConnectionException("unable to acquire database connection")
    private val INSERT_INTO= "INSERT INTO dbo.%s(%s) VALUES(%s);"
    private val DELETE= "delete from dbo.%s WHERE id = :id"
    private val FIND_SINGLE= "select * from dbo.%s WHERE id = :id"
    private val UPDATE_QUERY= "update dbo.%s set %s where id = :id;"
    private val FIND_ALL_WITH_CONDITION= "select * from dbo.%s %s"
    private val FIND_ALL= "select * from dbo.%s"
    private val EXISTS_QUERY = "select count(*) from dbo.%s %s where %s"

    private val TABLE_NAME = "${table}s".replace("ss", "s")



    override fun add(entity: T) : Int? {
        val list = cl.declaredFields.map { it.name }.filterNot { it == "id" }
        val keyHolder = GeneratedKeyHolder()
        val columns = list.joinToString(", ")
        val params =  list.joinToString(",") { ":$it" }
        val parameterSource = BeanPropertySqlParameterSource(entity)
        val formattedInsertQuery = String.format(INSERT_INTO, TABLE_NAME, columns, params)
        jdbcTemplate.update(formattedInsertQuery, parameterSource, keyHolder)
        return keyHolder.key?.toInt()
    }

    override fun delete(id: String?) {
        jdbcTemplate.update(String.format(DELETE, TABLE_NAME), mapOf("id" to id))
    }

    override fun update(entity: T) : Int? {
        val columns = this.cl.declaredFields.joinToString(",") { "${it.name} = :${it.name}" }
        val formattedQuery = String.format(UPDATE_QUERY, columns)
        return jdbcTemplate.update(formattedQuery, BeanPropertySqlParameterSource(entity))
    }

    override fun get(id: String?): T? {
        val params = mapOf("id" to id)
        val rowMapper  = BeanPropertyRowMapper.newInstance(cl)
        return jdbcTemplate.queryForObject(String.format(FIND_SINGLE, TABLE_NAME), params, rowMapper)
    }

    override fun getAllWithConditions(params : Map<String, String>): List<T> {
        val condition = "WHERE ${params.map { " ${it.key} = :${it.key}" }.joinToString(" AND")}"
        val rowMapper  = BeanPropertyRowMapper.newInstance(cl)
        return jdbcTemplate.query(String.format(FIND_ALL_WITH_CONDITION, TABLE_NAME, condition), params, rowMapper)
    }

    override fun getAll(): List<T> {
        val rowMapper  = BeanPropertyRowMapper.newInstance(cl)
        return jdbcTemplate.query(FIND_ALL, rowMapper)
    }

    override fun exists(params : Map<String, String>) : Int{
        val condition = params.map { " ${it.key} = :${it.key}" }.joinToString(" AND")
        val rowMapper  = BeanPropertyRowMapper.newInstance(cl)
        return jdbcTemplate.query(String.format(EXISTS_QUERY, condition), params, rowMapper).size
    }
}
