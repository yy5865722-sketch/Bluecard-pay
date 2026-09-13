package com.bluecardpay.app.data.repository

import com.bluecardpay.app.data.local.CardDao
import com.bluecardpay.app.domain.model.Card
import com.bluecardpay.app.domain.repository.CardRepository
import kotlinx.coroutines.flow.Flow

class CardRepositoryImpl(private val cardDao: CardDao) : CardRepository {
    override fun getCardFlow(): Flow<Card?> = cardDao.getCardFlow()

    override suspend fun getCard(): Card? = cardDao.getCard()

    override suspend fun updateCard(card: Card) = cardDao.update(card)

    override suspend fun insertCard(card: Card) = cardDao.insert(card)
}
