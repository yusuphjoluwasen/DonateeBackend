package com.serverless.lambda.modules

import com.serverless.utils.ApiCaller
import com.serverless.utils.ApiCallerImpl
import com.serverless.utils.AuthUtil
import com.serverless.utils.DbUtil
import org.koin.dsl.module

var donateemodule = module {

    single { DbUtil() }
    single { AuthUtil() }
    single<ApiCaller> { ApiCallerImpl() }

}