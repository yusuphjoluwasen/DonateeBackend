package com.serverless.utils

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.RestTemplate
import java.io.IOException
import java.util.*


class ApiCallerImpl : ApiCaller {

    val logger = LoggerFactory.getLogger(ApiCallerImpl::class.java)

    override fun postStringCall(uri: String, request: HashMap<String, Any>, token: String): HashMap<String, Any?> {
        val restTemplate = RestTemplate()
        val headers = HttpHeaders()
        println(request)
        headers.contentType = MediaType.APPLICATION_JSON
        headers["Authorization"] = token
        val entity = HttpEntity<Any>(request, headers)
        return try {
            val resp = restTemplate.postForObject(uri, entity, String::class.java)!!
            println(resp)
            stringToHashMap(resp)
        } catch (err: HttpClientErrorException) {
            val error = HashMap<String, Any?>()
            error["error"] = err.message
            error
        }
    }

    override fun postStringCall(uri: String, request: String, token: String): String {
        val restTemplate = RestTemplate()
        val headers = HttpHeaders()
        println(request)
        headers.contentType = MediaType.APPLICATION_JSON
        headers["Authorization"] = token
        val entity = HttpEntity<Any>(request, headers)
        return try {
            val resp = restTemplate.postForObject(uri, entity, String::class.java)!!
            println(resp)
            resp
        } catch (err: HttpClientErrorException) {
            err.toString()
        }
    }

    fun stringToHashMap(Response: String?): HashMap<String, Any?> {
        return try {
            //System.out.println(Arrays.asList(result)); // method 1
            ObjectMapper()
                    .readValue(Response, object : TypeReference<HashMap<String, Any?>?>() {})!!
        } catch (e: IOException) {
            val error = HashMap<String, Any?>()
            error["error"] = e.message
            error
        }
    }


    override fun postStringCall(uri: String?, request: HashMap<String?, Any?>?, token: HashMap<String?, Any?>?): HashMap<String, Any?> {
        val restTemplate = RestTemplate()
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        headers[token!!["header"].toString()] = token["token"].toString()
        val entity = HttpEntity<Any>(request, headers)
        println(request)
        return try {
            val resp = restTemplate.postForObject(uri!!, entity, String::class.java)!!
            println(resp)
            stringToHashMap(resp)
        } catch (err: HttpClientErrorException) {
            val error = HashMap<String, Any?>()
            error["error"] = err.message
            error
        }
    }

    override fun postStringCall(uri: String?, request: String?, token: HashMap<String, String>): String? {
        val restTemplate = RestTemplate()
        val headers = HttpHeaders()
        println(request)
        headers.contentType = MediaType.APPLICATION_JSON
        headers[token["header"]!!] = token["token"]
        val entity = HttpEntity<Any>(request, headers)
        return try {
            val resp = restTemplate.postForObject(uri!!, entity, String::class.java)!!
            println(resp)
            resp
        } catch (err: HttpClientErrorException) {
            err.message
        }
    }

    override fun postStringCall(uri: String?, request: String?): String? {
        val restTemplate = RestTemplate()
        val headers = HttpHeaders()
        println(request)
        headers.contentType = MediaType.APPLICATION_JSON
        val entity = HttpEntity(request, headers)
        return try {
            val resp = restTemplate.postForObject(uri!!, entity, String::class.java)!!
            println(resp)
            resp
        } catch (err: HttpClientErrorException) {
            err.localizedMessage
        }
    }

}