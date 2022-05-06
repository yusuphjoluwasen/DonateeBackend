package com.serverless.test

import com.serverless.lambda.modules.appModule
import org.junit.Test
import com.serverless.models.User
import com.serverless.repository.Repository
import com.serverless.repository.UserRepository
import com.serverless.services.UserService
import com.serverless.utils.DbUtil
import org.junit.Rule
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.fileProperties
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject

class MyTest : KoinTest {

    // Lazy inject property
    val dbUtil: DbUtil by inject()
    val userRepository: UserRepository by inject()
    val userService: UserService by inject()

    @get:Rule(order = 0)
    val koinTestRule = KoinTestRule.create{
        fileProperties(fileName = "/koin.properties")
        modules(appModule)
    }

    @Test
    fun `should inject my components`() {
        val user = User(2,"kola", "sola", "kola@gmail.com", "123456", "10, sola street, lagos","09087651235","charity","","")
        print(userRepository.updateUser(user))
    }


}




