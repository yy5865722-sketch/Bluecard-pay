package com.bluecardpay.app.domain.model

interface PaymentProvider {
    suspend fun initializePayment(amount: Double, currency: String): Boolean
    suspend fun completePayment(transactionId: String): Boolean
}

interface WalletProvider {
    suspend fun connectWallet(credentials: String): Boolean
    suspend fun disconnectWallet(): Boolean
}

interface CardProvider {
    suspend fun issueCard(cardData: Card): Boolean
    suspend fun updateCardStatus(cardId: Int, status: String): Boolean
}
