package com.serverless.repository

import com.serverless.exceptions.BadConnectionException
import com.serverless.models.User
import com.serverless.utils.DbUtil
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource
import org.springframework.jdbc.support.GeneratedKeyHolder


interface UserRepository {
    fun addUser(user: User): Int?
    fun updateUser(user: User): Any
    fun findAllUsers(): MutableList<User>
    fun findUserById(id: String): User?
}


class UserRepositoryImpl(private val dbUtil: DbUtil): UserRepository {
    private val jdbcTemplate = this.dbUtil.NAMED_JDBC_TEMPLATE ?: throw BadConnectionException("unable to acquire database connection")

    // CRUD PROJECT QUERIES
    private val UPDATE_USERS = "update users SET firstname = :firstname, lastname = :lastname, email = :email, password = :password, address = :address, mobilenumber = :mobilenumber, usertype = :usertype where id = :id"
    private val FIND_ALL_USERS = "select * from dbo.users"
    private val FIND_USER_BY_ID = "select * from dbo.users WHERE id = :id"
    private val INSERT_INTO_USERS = "INSERT INTO dbo.users(firstname, lastname, email, password, address, mobilenumber, usertype) VALUES(:firstname, :lastname,  :email, :password, :address, :mobilenumber, :usertype);"
    //private val FIND_PROJECTS_BY_APPLICANT = "select * from dbo.projects where applicantid = :id"
    //private val DELETE_USER = "delete from dbo.users WHERE id = :id"




    override fun addUser(user: User): Int? {
        val keyHolder = GeneratedKeyHolder()
        jdbcTemplate.update(INSERT_INTO_USERS, BeanPropertySqlParameterSource(user), keyHolder)
        return keyHolder.key?.toInt()
    }

    override fun updateUser(user: User): Any {
        return jdbcTemplate.update(UPDATE_USERS, BeanPropertySqlParameterSource(user))
    }

    override fun findAllUsers(): MutableList<User> {
        val rowMapper  = BeanPropertyRowMapper.newInstance(User::class.java)
        return jdbcTemplate.query(FIND_ALL_USERS, rowMapper)
    }

    override fun findUserById(id: String): User? {
        val params = mapOf("id" to id)
        val rowMapper  = BeanPropertyRowMapper.newInstance(User::class.java)
        return jdbcTemplate.queryForObject(FIND_USER_BY_ID, params, rowMapper)
    }


//    override fun deleteById(id: String): Any? {
//        return jdbcTemplate.update(DELETE_BY_ID, mapOf("id" to  id))
//    }



}

//class UserRepository(dbUtil: DbUtil): Repository<User>(dbUtil, User::class.java)