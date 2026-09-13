package com.bluecardpay.app.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val merchantName: String,
    val amount: Double,
    val currency: String = "EUR",
    val category: String,
    val status: String = "Completed",
    val transactionDate: Long = System.currentTimeMillis(),
    val description: String = "",
    val type: String = "Purchase"
)
