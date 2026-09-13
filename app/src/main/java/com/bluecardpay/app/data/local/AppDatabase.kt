package com.bluecardpay.app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bluecardpay.app.domain.model.AppSettings
import com.bluecardpay.app.domain.model.Card
import com.bluecardpay.app.domain.model.ScannedCode
import com.bluecardpay.app.domain.model.Transaction

@Database(
    entities = [Card::class, Transaction::class, AppSettings::class, ScannedCode::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cardDao(): CardDao
    abstract fun transactionDao(): TransactionDao
    abstract fun settingsDao(): SettingsDao
    abstract fun scannedCodeDao(): ScannedCodeDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "bluecard_pay_db"
                ).build().also { INSTANCE = it }
            }
    }
}
