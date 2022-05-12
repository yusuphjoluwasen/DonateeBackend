package com.serverless.services

import com.serverless.models.User
import com.serverless.repository.UserRepository

class UserService(private val userRepository: UserRepository) {

    fun addUser(user: User): Int? {
        return userRepository.addUser(user)
    }

    fun findUserById(id: String): User? {
        return userRepository.findUserById(id)
    }

    fun findAllUsers(): List<User> {
        return userRepository.findAllUsers()
    }

    fun updateUser(user: User): Any? {
        return userRepository.updateUser(user)
    }

    fun findUserByEmailOrByPhone(emailOrPhone: String) : User? {
        return userRepository.findUserByEmailOrByPhone(emailOrPhone)
    }

}