package com.bluecardpay.app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bluecardpay.app.domain.model.ScannedCode
import kotlinx.coroutines.flow.Flow

@Dao
interface ScannedCodeDao {
    @Query("SELECT * FROM scanned_codes ORDER BY scannedAt DESC LIMIT 50")
    fun getRecentScannedCodesFlow(): Flow<List<ScannedCode>>

    @Insert
    suspend fun insert(scannedCode: ScannedCode)
}
