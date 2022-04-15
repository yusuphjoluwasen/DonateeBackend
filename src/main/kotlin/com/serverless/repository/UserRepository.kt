package com.serverless.repository

import com.serverless.exceptions.BadConnectionException
import com.serverless.models.User
import com.serverless.utils.DbUtil
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource
import org.springframework.jdbc.support.GeneratedKeyHolder


interface UserRepository {
    fun addUser(user: User): Int?
    fun updateUser(user: User)
    fun findAllUsers(): MutableList<User>
    fun findUserById(id: String): User?
}


class UserRepositoryImpl(private val dbUtil: DbUtil): UserRepository {
    private val jdbcTemplate = this.dbUtil.NAMED_JDBC_TEMPLATE ?: throw BadConnectionException("unable to acquire database connection")


    override fun addUser(user: User): Int? {
        TODO("Not yet implemented")
    }

    override fun updateUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun findAllUsers(): MutableList<User> {
        TODO("Not yet implemented")
    }

    override fun findUserById(id: String): User? {
        TODO("Not yet implemented")
    }


}