package com.bluecardpay.app.data.repository

import com.bluecardpay.app.data.local.SettingsDao
import com.bluecardpay.app.domain.model.AppSettings
import com.bluecardpay.app.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow

class SettingsRepositoryImpl(private val settingsDao: SettingsDao) : SettingsRepository {
    override fun getSettingsFlow(): Flow<AppSettings> = settingsDao.getSettingsFlow()

    override suspend fun getSettings(): AppSettings = settingsDao.getSettings() ?: AppSettings()

    override suspend fun updateSettings(settings: AppSettings) = settingsDao.update(settings)
}
