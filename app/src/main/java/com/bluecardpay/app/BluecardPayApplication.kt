package com.bluecardpay.app

import android.app.Application
import android.content.Context
import com.bluecardpay.app.data.local.AppDatabase
import com.bluecardpay.app.data.repository.CardRepositoryImpl
import com.bluecardpay.app.data.repository.SettingsRepositoryImpl
import com.bluecardpay.app.data.repository.TransactionRepositoryImpl
import com.bluecardpay.app.domain.model.Card
import com.bluecardpay.app.domain.repository.CardRepository
import com.bluecardpay.app.domain.repository.SettingsRepository
import com.bluecardpay.app.domain.repository.TransactionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BluecardPayApplication : Application() {
    private lateinit var database: AppDatabase
    lateinit var cardRepository: CardRepository
    lateinit var transactionRepository: TransactionRepository
    lateinit var settingsRepository: SettingsRepository

    override fun onCreate() {
        super.onCreate()
        initializeDatabase(this)
        initializeRepositories()
        initializeDefaultData()
    }

    private fun initializeDatabase(context: Context) {
        database = AppDatabase.getInstance(context)
    }

    private fun initializeRepositories() {
        cardRepository = CardRepositoryImpl(database.cardDao())
        transactionRepository = TransactionRepositoryImpl(database.transactionDao())
        settingsRepository = SettingsRepositoryImpl(database.settingsDao())
    }

    private fun initializeDefaultData() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val existingCard = database.cardDao().getCard()
                if (existingCard == null) {
                    val defaultCard = Card(
                        cardholderName = "Youcef",
                        maskedCardNumber = "\u2022\u2022\u2022\u2022 \u2022\u2022\u2022\u2022 \u2022\u2022\u2022\u2022 1234",
                        lastFourDigits = "1234",
                        expirationDate = "12/28",
                        cardNetwork = "VISA",
                        currency = "EUR",
                        cardStatus = "Active"
                    )
                    database.cardDao().insert(defaultCard)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
