package com.serverless.extensions

import com.google.gson.Gson
import com.serverless.exceptions.BadRequestException
import javax.validation.Validation

inline fun <reified T> String.validate(): T {
    val requestObject = Gson().fromJson(this, T::class.java)
    val violations = Validation.buildDefaultValidatorFactory().validator.validate(requestObject)
    if (violations.isNotEmpty()) throw BadRequestException(violations.joinToString(",") { it.message })
    return requestObject
}