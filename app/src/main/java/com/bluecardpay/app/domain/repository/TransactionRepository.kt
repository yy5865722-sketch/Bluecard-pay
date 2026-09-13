package com.bluecardpay.app.domain.repository

import com.bluecardpay.app.domain.model.Transaction
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {
    fun getAllTransactionsFlow(): Flow<List<Transaction>>
    suspend fun getAllTransactions(): List<Transaction>
    suspend fun getTransactionsByCategory(category: String): List<Transaction>
    suspend fun insertTransaction(transaction: Transaction)
    suspend fun deleteTransaction(transaction: Transaction)
}
