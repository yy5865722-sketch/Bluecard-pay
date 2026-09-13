package com.bluecardpay.app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.bluecardpay.app.domain.model.AppSettings
import kotlinx.coroutines.flow.Flow

@Dao
interface SettingsDao {
    @Query("SELECT * FROM app_settings LIMIT 1")
    fun getSettingsFlow(): Flow<AppSettings>

    @Query("SELECT * FROM app_settings LIMIT 1")
    suspend fun getSettings(): AppSettings?

    @Insert
    suspend fun insert(settings: AppSettings)

    @Update
    suspend fun update(settings: AppSettings)
}
