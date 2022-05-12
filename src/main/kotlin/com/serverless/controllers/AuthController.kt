package com.serverless.controllers

import com.serverless.exceptions.*
import com.serverless.extensions.*
import com.serverless.requests.LoginRequest
import com.serverless.responses.LoginCharityResponse
import com.serverless.services.UserService
import com.serverless.utils.AuthUtil

class AuthController(private val authUtil: AuthUtil, private val userService: UserService) {

    fun userLogin(request: String): Any {
        val login = request.validate<LoginRequest>()
        val user = userService.findUserByEmailOrByPhone(login.username!!) ?: throw ItemNotFoundException("invalid login credentials")
        if(login.password doesNotMatch user.password) throw IncorrectPasswordException("invalid login credentials")

        return when(user.usertype){
            "charity" -> {
               return LoginCharityResponse("00","00",authUtil.generateJWT(user),user)
            }
            else -> {
                return LoginCharityResponse("00","00",authUtil.generateJWT(user),user)
            }
        }
    }
}