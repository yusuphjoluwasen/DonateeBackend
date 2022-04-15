package com.serverless.controllers

import com.serverless.responses.BaseResponse
import com.serverless.services.UserService

class UserController(private val userService: UserService) {


    fun createUser(): BaseResponse {
        return BaseResponse("00", "success")
    }


}