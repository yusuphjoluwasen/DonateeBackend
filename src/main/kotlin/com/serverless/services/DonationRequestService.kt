package com.serverless.services

import com.serverless.models.CharityOrganization
import com.serverless.models.DonationRequest
import com.serverless.repository.DonationRequestRepository

class DonationRequestService(private val donationRequestRepository: DonationRequestRepository) {
    fun addDonationRequest(user: CharityOrganization): String?{
        return donationRequestRepository.addDonationRequest(user)
    }
    fun updateDonationRequest(user: CharityOrganization): String? {
        return donationRequestRepository.updateDonationRequest(user)
    }
    fun findDonationRequestsById(id: String): DonationRequest? {
        return donationRequestRepository.findDonationRequestById(id)
    }
    fun findAllRequests():MutableList<DonationRequest>{
        return donationRequestRepository.findAllRequests()
    }

}