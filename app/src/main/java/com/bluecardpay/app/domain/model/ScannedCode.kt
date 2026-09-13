package com.bluecardpay.app.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scanned_codes")
data class ScannedCode(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val codeContent: String,
    val codeType: String,
    val scannedAt: Long = System.currentTimeMillis()
)
