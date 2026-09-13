package com.bluecardpay.app.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.bluecardpay.app.domain.model.Card
import kotlinx.coroutines.flow.Flow

@Dao
interface CardDao {
    @Query("SELECT * FROM cards LIMIT 1")
    fun getCardFlow(): Flow<Card?>

    @Query("SELECT * FROM cards LIMIT 1")
    suspend fun getCard(): Card?

    @Insert
    suspend fun insert(card: Card)

    @Update
    suspend fun update(card: Card)

    @Delete
    suspend fun delete(card: Card)
}
