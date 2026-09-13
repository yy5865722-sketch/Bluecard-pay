package com.bluecardpay.app.domain.repository

import com.bluecardpay.app.domain.model.AppSettings
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    fun getSettingsFlow(): Flow<AppSettings>
    suspend fun getSettings(): AppSettings
    suspend fun updateSettings(settings: AppSettings)
}
