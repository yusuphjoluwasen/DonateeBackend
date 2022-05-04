package com.serverless.repository
import com.serverless.exceptions.BadConnectionException
import com.serverless.models.CharityOrganization
import com.serverless.models.User
import com.serverless.utils.DbUtil
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource
import org.springframework.jdbc.support.GeneratedKeyHolder


interface CharityOrganizationRepository{
    fun addCharity(user: CharityOrganization): Int?
    fun updateCharity(user: CharityOrganization)
    fun findAllCharities(): MutableList<CharityOrganization>
    fun findCharityById(id: String): CharityOrganization?
    fun addRequest(user: CharityOrganization): Int?
    fun updateRequest(user: CharityOrganization): Int?
}

class CharityOrganizationRepositoryImpl (private val dbUtil: DbUtil): CharityOrganizationRepository {
    private val jdbcTemplate = this.dbUtil.NAMED_JDBC_TEMPLATE ?: throw BadConnectionException("unable to acquire database connection")
    override fun addCharity(user: CharityOrganization): Int? {
        TODO("Not yet implemented")
    }

    override fun updateCharity(user: CharityOrganization) {
        TODO("Not yet implemented")
    }

    override fun findAllCharities(): MutableList<CharityOrganization> {
        TODO("Not yet implemented")
    }

    override fun findCharityById(id: String): CharityOrganization? {
        TODO("Not yet implemented")
    }

    override fun addRequest(user: CharityOrganization): Int? {
        TODO("Not yet implemented")
    }

    override fun updateRequest(user: CharityOrganization): Int? {
        TODO("Not yet implemented")
    }


}
