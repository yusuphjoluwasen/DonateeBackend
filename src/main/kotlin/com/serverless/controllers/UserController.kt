package com.serverless.controllers

import com.serverless.exceptions.ItemNotFoundException
import com.serverless.extensions.validate
import com.serverless.models.User
import com.serverless.requests.CreateUserRequest
import com.serverless.requests.FindUserRequest
import com.serverless.requests.UpdateUserRequest
import com.serverless.responses.BaseResponse
import com.serverless.responses.UserResponse
import com.serverless.responses.UsersResponse
import com.serverless.services.UserService

class UserController(private val userService: UserService) {

    fun createUser(request: String): BaseResponse {
        val createUserRequest = request.validate<CreateUserRequest>()
        val user = User(0,createUserRequest.firstname,createUserRequest.lastname,createUserRequest.email,createUserRequest.password,createUserRequest.address,createUserRequest.mobilenumber,createUserRequest.usertype)
        userService.addUser(user)
        return BaseResponse("00", "created user sucessfully")
    }

    fun updateUser(request: String):BaseResponse{
        val createUserRequest = request.validate<UpdateUserRequest>()
        val user = User(createUserRequest.id?.toInt(),createUserRequest.firstname,createUserRequest.lastname,createUserRequest.email,createUserRequest.password,createUserRequest.address,createUserRequest.mobilenumber,createUserRequest.usertype)
        userService.updateUser(user)
        return BaseResponse("00", "updated user sucessfully")
    }

    fun findAllUsers(): UsersResponse{
        val users = userService.findAllUsers()
        return UsersResponse("00","fetched users sucessfully",users)
    }

    fun findUsersById(request: String): UserResponse{
        val findApplicantRequest = request.validate<FindUserRequest>()
        val user = userService.findUserById(findApplicantRequest.id.toString()) ?: throw ItemNotFoundException("unable to find user")
        return UserResponse("00","fetched user sucessfully",user)
    }

}