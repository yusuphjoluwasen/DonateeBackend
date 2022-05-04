package com.serverless.controllers

import com.serverless.responses.BaseResponse
import com.serverless.services.DonationItemService

class DonationItemController (private val donationItemService: DonationItemService) {
    fun addDonation(): BaseResponse{
        return BaseResponse("","")
    }

    fun updateDonation(): BaseResponse{
        return BaseResponse("","")
    }

    fun findAllDonations(): BaseResponse{
        return BaseResponse("","")
    }

    fun findDonationsById(): BaseResponse{
        return BaseResponse("","")
    }
}