package com.serverless.repository

import com.serverless.models.CharityOrganization
import com.serverless.models.DonationRequest
import com.serverless.utils.DbUtil

interface DonationRequestRepository{
    fun addDonationRequest(user: CharityOrganization):String?
    fun updateDonationRequest(user: CharityOrganization):String?
    fun findDonationRequestById(id: String): DonationRequest?
    fun findAllRequests(): MutableList<DonationRequest>

}

class DonationRequestRepositoryImp (private val dbUtil: DbUtil): DonationRequestRepository{
    override fun addDonationRequest(user: CharityOrganization): String? {
        TODO("Not yet implemented")
    }

    override fun updateDonationRequest(user: CharityOrganization): String? {
        TODO("Not yet implemented")
    }

    override fun findDonationRequestById(id: String): DonationRequest? {
        TODO("Not yet implemented")
    }

    override fun findAllRequests(): MutableList<DonationRequest> {
        TODO("Not yet implemented")
    }
}