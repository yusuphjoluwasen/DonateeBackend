package com.serverless.services

import com.serverless.models.DonationItem
import com.serverless.models.User
import com.serverless.repository.DonationItemRepository

class DonationItemService(private val donationItemRepository: DonationItemRepository) {
    fun addDonation (user: User) :Int?{
        return donationItemRepository.addDonation(user)
    }

    fun updateDonation(user: User): Int?{
        return donationItemRepository.updateDonation(user)
    }

    fun findAllDonations(): MutableList<DonationItem>{
        return donationItemRepository.findAllDonations()
    }

    fun findDonationById(id: String): DonationItem?{
        return donationItemRepository.findDonationById(id)
    }

}