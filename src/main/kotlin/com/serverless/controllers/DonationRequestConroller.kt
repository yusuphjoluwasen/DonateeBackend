package com.serverless.controllers

import com.serverless.responses.BaseResponse
import com.serverless.services.DonationRequestService

class DonationRequestController (private val donationRequestService: DonationRequestService){
    fun addDonationRequest(): BaseResponse{
        return BaseResponse("","")
    }

    fun updateDonationRequest(): BaseResponse{
        return BaseResponse("","")
    }

    fun findDonationRequestById():BaseResponse{
        return BaseResponse("","")
    }

    fun findAllRequests(): BaseResponse{
        return BaseResponse("","")
    }
}