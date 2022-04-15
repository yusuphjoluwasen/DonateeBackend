package com.serverless.utils

import org.springframework.web.client.HttpClientErrorException

interface ApiCaller {

    @Throws(HttpClientErrorException::class)
    fun postStringCall(uri: String, request: HashMap<String, Any>, token: String): HashMap<String, Any?>

    @Throws(HttpClientErrorException::class)
    fun postStringCall(uri: String?, request: HashMap<String?, Any?>?, token: HashMap<String?, Any?>?): HashMap<String, Any?>?

    @Throws(HttpClientErrorException::class)
    fun postStringCall(uri: String?, request: String?, token: HashMap<String, String>): String?

    @Throws(HttpClientErrorException::class)
    fun postStringCall(uri: String?, request: String?): String?

    @Throws(HttpClientErrorException::class)
    fun postStringCall(uri: String, request: String, token: String): String

}