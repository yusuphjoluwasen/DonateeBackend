package com.serverless.responses

import com.serverless.models.User

data class BaseResponse (var responsecode: String, var responsemessage: String)
data class UserResponse (var responsecode: String, var responsemessage: String, var user:User?)
data class UsersResponse (var responsecode: String, var responsemessage: String, var users:List<User>?)
data class LoginDonorResponse (var responsecode: String, var responsemessage: String, var token:String?, var user:User?)
data class LoginCharityResponse (var responsecode: String, var responsemessage: String, var token:String? ,var user:User?)