package com.serverless.lambda.modules

import com.serverless.controllers.AuthController
import com.serverless.controllers.UserController
import com.serverless.repository.UserRepository
import com.serverless.repository.UserRepositoryImpl
import com.serverless.services.UserService
import com.serverless.utils.ApiCaller
import com.serverless.utils.ApiCallerImpl
import com.serverless.utils.AuthUtil
import com.serverless.utils.DbUtil
import org.koin.dsl.module

var appModule = module {

    single { DbUtil() }
    single { AuthUtil() }

    // todo register repository
    single <UserRepository> { UserRepositoryImpl(get()) }



    // todo register service
    single {UserService(get())}




    // todo register controller
    single {UserController(get())}
    single {AuthController(get(), get())}


}