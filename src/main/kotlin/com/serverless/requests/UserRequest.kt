package com.serverless.requests

import javax.validation.constraints.NotEmpty

data class CreateUserRequest(
    @get: NotEmpty(message = "email is required")
    var email: String?,
    @get: NotEmpty(message = "firstname is required")
    var firstname: String?,
    @get: NotEmpty(message = "lastname is required")
    var lastname: String?,
    @get: NotEmpty(message = "mobilenumber is required")
    var mobilenumber: String?,
    @get: NotEmpty(message = "Password is required")
    var password: String?,
    @get: NotEmpty(message = "Address is required")
    var address: String?,
    @get: NotEmpty(message = "UserType is required")
    var usertype: String?
    )

data class UpdateUserRequest(
    @get: NotEmpty(message = "id is required")
    var userid: String?,
    @get: NotEmpty(message = "email is required")
    var email: String?,
    @get: NotEmpty(message = "firstname is required")
    var firstname: String?,
    @get: NotEmpty(message = "lastname is required")
    var lastname: String?,
    @get: NotEmpty(message = "mobilenumber is required")
    var mobilenumber: String?,
    @get: NotEmpty(message = "Password is required")
    var password: String?,
    @get: NotEmpty(message = "Address is required")
    var address: String?,
    @get: NotEmpty(message = "UserType is required")
    var usertype: String?
)


data class FindUserRequest(
    @get: NotEmpty(message = "id is required")
    var userid: String?,
)
