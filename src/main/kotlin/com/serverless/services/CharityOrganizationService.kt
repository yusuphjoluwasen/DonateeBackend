package com.serverless.services

import com.serverless.models.CharityOrganization
import com.serverless.repository.CharityOrganizationRepository

class CharityOrganizationService(private val charityOrganizationRepository :CharityOrganizationRepository){

    fun addCharity(user: CharityOrganization): Int? {
        return charityOrganizationRepository.addCharity(user)
    }

    fun updateCharity(user: CharityOrganization){
        return charityOrganizationRepository.updateCharity(user)
    }

    fun findAllCharities(): MutableList<CharityOrganization>{
        return charityOrganizationRepository.findAllCharities()
    }

    fun findCharityById(id:String): CharityOrganization? {
        return charityOrganizationRepository.findCharityById(id)
    }

    fun addRequest(user: CharityOrganization): Int?{
        return charityOrganizationRepository.addRequest(user)
    }
    fun updateRequest(user: CharityOrganization): Int?{
        return charityOrganizationRepository.updateRequest(user)
    }
}