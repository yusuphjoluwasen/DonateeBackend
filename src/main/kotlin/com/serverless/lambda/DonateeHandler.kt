//package com.serverless.lambda
//
//import com.amazonaws.services.lambda.runtime.Context
//import com.amazonaws.services.lambda.runtime.LambdaLogger
//import com.amazonaws.services.lambda.runtime.RequestStreamHandler
//import com.google.gson.GsonBuilder
//import com.serverless.controllers.UserController
//import com.serverless.exceptions.*
//import com.serverless.lambda.modules.donateemodule
//import com.serverless.lambda.request.AWSLambdaRequest
//import com.serverless.lambda.response.AwsLambdaResponse
//import main
//import org.koin.core.context.GlobalContext.startKoin
//import org.koin.dsl.module
//import org.koin.fileProperties
//import org.koin.java.KoinJavaComponent
//import java.io.InputStream
//import java.io.InputStreamReader
//import java.io.OutputStream
//import java.io.OutputStreamWriter
//
//
//// step 1: Initiate Low-level request-handling interface,
//// Lambda stream request handlers implement AWS Lambda Function
//// application logic using input and output stream
//
//
//class DonateeHandler : RequestStreamHandler {
//    private lateinit var logger: LambdaLogger
//
//    init {
//        startKoin {
//            fileProperties()
//            modules(donateemodule)
//        }
//    }
//
//    override fun handleRequest(input: InputStream, output: OutputStream, context: Context) {
//        logger = context.logger
//        val gson = GsonBuilder().serializeNulls().create()
//        val inputStreamReader = InputStreamReader(input)
//        val request  = gson.fromJson(inputStreamReader, AWSLambdaRequest::class.java)
//        logger.log("handleRequest: Handling incoming task request. Input: ${request.body}")
//
//        val path = request.pathParameters.proxy
//
//        val user : UserController by KoinJavaComponent.inject(UserController::class.java)
//
//        val response = main {
//            when(path.lowercase()){
//
//                // user endpoints
//                "user/create-user" -> user.createUser()
//
//                else ->  throw InvalidRouteException("invalid route")
//            }
//        }
//
//        logger.log("Response: ${gson.toJson(AwsLambdaResponse(body =  gson.toJson(response)).body).replace("\\", "")}")
//        val writer = OutputStreamWriter(output, "UTF-8")
//        writer.closeStreamWith(gson.toJson(AwsLambdaResponse(body = gson.toJson(response))))
//
//
//    }
//}
