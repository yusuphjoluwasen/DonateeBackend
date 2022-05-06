package com.serverless.services

import com.serverless.models.User
import com.serverless.repository.UserRepository

class UserService(private val userRepository: UserRepository) {

    fun addUser(user: User): Int? {
//        return userRepository.add(user)
        print("kkk")
        return 0
    }

    fun findUserById(id: String): User? {
        return userRepository.findUserById(id)
    }

    fun findAllUsers(): List<User> {
        return userRepository.findAllUsers()
    }


}