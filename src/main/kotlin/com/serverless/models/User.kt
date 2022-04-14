package com.serverless.models

class User {
    var id: String? = null
    var firstname: String? = null
    var lastname: String? = null
    var email: String? = null
    var password: String? = null
    var mobilenumber: String? = null
    var gender: String? = null
    var status: String? = null
    var usertype: String? = null
    var country: String? = null
    var state: String? = null
    var profilepicture: String? = null
    var briefdescription: String? = null
    var createdat: String? = null
    var modifiedat: String? = null

    constructor()

    constructor(
        firstname: String?,
        lastname: String?,
        email: String?,
        password: String?,
        mobilenumber: String?,
        gender: String?,
        status: String?,
        usertype: String?,
        country: String?,
        state: String?,
        profilepicture: String?,
        briefdescription: String?
    ) {
        this.firstname = firstname
        this.lastname = lastname
        this.email = email
        this.password = password
        this.mobilenumber = mobilenumber
        this.gender = gender
        this.status = status
        this.usertype = usertype
        this.country = country
        this.state = state
        this.profilepicture = profilepicture
        this.briefdescription = briefdescription
    }


}