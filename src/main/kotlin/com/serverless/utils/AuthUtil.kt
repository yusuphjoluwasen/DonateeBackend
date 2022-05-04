//package com.serverless.utils
//
//import com.serverless.exceptions.AccessNotAllowedException
//import com.serverless.models.User
//import io.jsonwebtoken.Claims
//import io.jsonwebtoken.Jwts
//import io.jsonwebtoken.security.InvalidKeyException
//import io.jsonwebtoken.security.Keys
//import org.mindrot.jbcrypt.BCrypt
//import java.util.*
//import java.util.function.Function
//
//class AuthUtil {
//
//    private val JWT_KEY = "DummyKeyStringDummyKeyStringsDummyKeyStrings"
//
////    private val OPEN_ENDPOINTS = listOf("auth/login")
////
//////    fun generateJWT(user: User) : String {
//////        val claims = mapOf(
//                "userid" to user.id,
//                "email" to user.email,
//                "firstname" to user.firstname,
//                "lastname" to user.lastname,
//                "mobilenumber" to user.mobilenumber,
//                "gender" to user.gender,
//                "usertype" to user.usertypeid,
//                "status" to user.status)
//        val token = Jwts.builder().setSubject(user.email)
//            .addClaims(claims)
//            .setIssuedAt(Date(System.currentTimeMillis()))
//            .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 60))
//            .signWith(Keys.hmacShaKeyFor(JWT_KEY.toByteArray())).compact()
//        return  "Bearer $token"
//    }
//
//
//
//    private fun extractAllClaims(token: String?): Claims {
//        if(token.isNullOrEmpty()) throw InvalidKeyException("Authorization is required for this endpoint")
//        if (!token.startsWith("Bearer ")) throw InvalidKeyException("JWT Token must begin with Bearer")
//        return Jwts.parserBuilder()
//            .setSigningKey(Keys.hmacShaKeyFor(JWT_KEY.toByteArray())).build()
//            .parse(token.substring(7)).body as Claims
//    }
//
//    private fun <T> extractClaim(token: String?, claimsResolver: Function<Claims, T>): T {
//        val claims = extractAllClaims(token)
//        return claimsResolver.apply(claims)
//    }
//
//
//    fun extractSubject(token: String?): String {
//        return extractClaim(token, Function { obj -> obj.subject })
//    }
//
//    fun validateAccess(authorizationHeader : String?, path : String?){
//        if(authorizationHeader.isNullOrEmpty() && path !in OPEN_ENDPOINTS) throw AccessNotAllowedException("authorization is required for this endpoint")
//    }
//
//}