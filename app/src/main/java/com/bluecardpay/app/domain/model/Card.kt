package com.bluecardpay.app.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cards")
data class Card(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val cardholderName: String = "Youcef",
    val maskedCardNumber: String = "•••• •••• •••• 1234",
    val lastFourDigits: String = "1234",
    val expirationDate: String = "12/28",
    val cardNetwork: String = "VISA",
    val cardStatus: String = "Active",
    val isEnabled: Boolean = true,
    val onlinePaymentsEnabled: Boolean = true,
    val contactlessEnabled: Boolean = true,
    val spendingNotificationsEnabled: Boolean = true,
    val currency: String = "EUR",
    val balance: Double = 0.0,
    val createdAt: Long = System.currentTimeMillis()
)
