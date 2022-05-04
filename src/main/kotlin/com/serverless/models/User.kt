package com.serverless.models

data class User (
    var id: String? = null,
    var firstname: String? = null,
    var lastname: String? = null,
    var email: String? = null,
    var password: String? = null,
    var address: String? = null,
    var mobilenumber: String? = null,
    var usertype: String? = null,
    var createdat: String? = null,
    var modifiedat: String? = null


)