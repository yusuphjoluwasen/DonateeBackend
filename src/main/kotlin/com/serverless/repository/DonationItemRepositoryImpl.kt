package com.serverless.repository

import com.serverless.exceptions.BadConnectionException
import com.serverless.models.DonationItem
import com.serverless.models.User
import com.serverless.utils.DbUtil

interface DonationItemRepository{
    fun addDonation(user: User): Int?
    fun updateDonation(user: User):Int?
    fun findAllDonations(): MutableList<DonationItem>
    fun findDonationById(id: String):DonationItem?
}

class DonationItemRepositoryImpl (private val dbUtil: DbUtil): DonationItemRepository{
    private val jdbcTemplate = this.dbUtil.NAMED_JDBC_TEMPLATE ?: throw BadConnectionException("unable to acquire database connection")
    override fun addDonation(user: User): Int? {
        TODO("Not yet implemented")
    }

    override fun updateDonation(user: User): Int? {
        TODO("Not yet implemented")
    }

    override fun findAllDonations(): MutableList<DonationItem> {
        TODO("Not yet implemented")
    }

    override fun findDonationById(id: String): DonationItem? {
        TODO("Not yet implemented")
    }

}