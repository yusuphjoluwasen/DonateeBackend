package com.serverless.exceptions


data class AccountNotActiveException(override val message: String) : RuntimeException(message)
data class OTPExpiredException(override val message: String) : RuntimeException(message)
data class ItemNotFoundException(override val message: String) : RuntimeException(message)
data class InvalidOTPException(override val message: String) : RuntimeException(message)
data class BadRequestException(override val message: String) : RuntimeException(message)
data class InvalidRouteException(override val message: String) : RuntimeException(message)
data class ApiErrorException(override val message: String) : RuntimeException(message)
data class IncorrectPasswordException(override val message: String) : RuntimeException(message)
data class BadConnectionException(override val message: String) : RuntimeException(message)
data class ItemAlreadyExistException(override val message: String) : RuntimeException(message)
data class AccessNotAllowedException(override val message: String) : RuntimeException(message)
data class InvalidActionException(override val message: String) : RuntimeException(message)
data class InvalidEnumException(override val message: String) : RuntimeException(message)
