package com.bluecardpay.app.domain.repository

import com.bluecardpay.app.domain.model.Card
import kotlinx.coroutines.flow.Flow

interface CardRepository {
    fun getCardFlow(): Flow<Card?>
    suspend fun getCard(): Card?
    suspend fun updateCard(card: Card)
    suspend fun insertCard(card: Card)
}
