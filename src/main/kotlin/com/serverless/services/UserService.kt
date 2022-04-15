package com.serverless.services

import com.serverless.models.User
import com.serverless.repository.UserRepository

class UserService(private val userRepository: UserRepository) {

    fun addUser(user: User): User? {
        return userRepository.addUser(user)
    }

    fun findUserById(id: String): User? {
        return userRepository.findUserById(id)
    }

    fun findAllUsers(): MutableList<User> {
        return userRepository.findAllUsers()
    }


}