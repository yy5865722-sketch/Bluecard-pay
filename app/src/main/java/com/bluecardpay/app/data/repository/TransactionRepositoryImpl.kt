package com.bluecardpay.app.data.repository

import com.bluecardpay.app.data.local.TransactionDao
import com.bluecardpay.app.domain.model.Transaction
import com.bluecardpay.app.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow

class TransactionRepositoryImpl(private val transactionDao: TransactionDao) : TransactionRepository {
    override fun getAllTransactionsFlow(): Flow<List<Transaction>> = transactionDao.getAllTransactionsFlow()

    override suspend fun getAllTransactions(): List<Transaction> = transactionDao.getAllTransactions()

    override suspend fun getTransactionsByCategory(category: String): List<Transaction> =
        transactionDao.getTransactionsByCategory(category)

    override suspend fun insertTransaction(transaction: Transaction) = transactionDao.insert(transaction)

    override suspend fun deleteTransaction(transaction: Transaction) = transactionDao.delete(transaction)
}
