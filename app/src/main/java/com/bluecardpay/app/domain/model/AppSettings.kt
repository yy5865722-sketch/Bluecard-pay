package com.bluecardpay.app.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "app_settings")
data class AppSettings(
    @PrimaryKey
    val id: Int = 0,
    val darkModeEnabled: Boolean = false,
    val notificationsEnabled: Boolean = true,
    val privacyAccepted: Boolean = false,
    val biometricEnabled: Boolean = false,
    val lastUpdated: Long = System.currentTimeMillis()
)
