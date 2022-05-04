package com.serverless.controllers

import com.serverless.models.CharityOrganization
import com.serverless.responses.BaseResponse
import com.serverless.services.CharityOrganizationService

class CharityOrganizationController(private val charityOrganizationService: CharityOrganizationService) {
    fun addCharity(): BaseResponse{
        return BaseResponse("","")
    }

    fun updateCharity(): BaseResponse{
        return BaseResponse("","")
    }

    fun findAllCharities(): BaseResponse{
        return BaseResponse("","")
    }

    fun findCharityById(): BaseResponse{
        return BaseResponse("","")
    }

    fun addRequest(): BaseResponse{
        return BaseResponse("", "")
    }

    fun updateRequest(): BaseResponse{
        return BaseResponse("","")
    }
}