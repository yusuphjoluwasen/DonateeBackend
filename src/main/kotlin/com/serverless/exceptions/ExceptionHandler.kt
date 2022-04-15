package com.serverless.exceptions

import com.serverless.responses.BaseResponse
import org.springframework.dao.EmptyResultDataAccessException
import java.time.format.DateTimeParseException

inline fun main(action: () -> Any): Any {
    return try {
        action()
    } catch (ex : RuntimeException) {
        val pair = when (ex) {
            is OTPExpiredException ->  Pair("90", ex.message)
            is ItemNotFoundException ->  Pair("91", ex.message)
            is InvalidOTPException ->  Pair("93", ex.message)
            is BadRequestException ->  Pair("98", ex.message)
            is ItemAlreadyExistException ->  Pair("97", ex.message)
            is EmptyResultDataAccessException -> Pair("89",  "item does not exist")
            is BadConnectionException -> Pair("998", ex.message)
            is InvalidRouteException ->  Pair("999", ex.message)
            is AccountNotActiveException ->  Pair("83", ex.message)
            is AccessNotAllowedException ->  Pair("82", ex.message)
            is InvalidActionException ->  Pair("92", ex.message)
            is InvalidEnumException -> Pair("87", "Does not match any of the enum values")
            is IncorrectPasswordException -> Pair("81", ex.message)
            is DateTimeParseException ->  Pair("88", "unable to parse timestamp")
            else -> Pair("95", "something went wrong")
        }
        ex.printStackTrace()
        BaseResponse(pair.first, pair.second)
    }

}