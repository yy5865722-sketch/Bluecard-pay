package com.bluecardpay.app.utils

import com.bluecardpay.app.domain.model.Card

object CardCodeGenerator {
    fun generateQRCodeContent(card: Card): String {
        return "BLUECARDPAY|${card.lastFourDigits}|${card.cardholderName}|${card.currency}"
    }

    fun generateBarcodeContent(): String {
        return "1234567890128"
    }
}
