package com.bluecardpay.app.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bluecardpay.app.domain.model.Card
import com.bluecardpay.app.domain.repository.CardRepository
import com.bluecardpay.app.domain.repository.TransactionRepository
import com.bluecardpay.app.ui.components.VirtualCardDisplay

@Composable
fun HomeScreen(
    cardRepository: CardRepository,
    transactionRepository: TransactionRepository,
    onShowQR: () -> Unit,
    onShowBarcode: () -> Unit,
    onScanQR: () -> Unit,
    onScanBarcode: () -> Unit,
    onCardControls: () -> Unit,
    onTransactions: () -> Unit
) {
    val card by cardRepository.getCardFlow().collectAsState(initial = null)

    val defaultCard = card ?: Card(
        cardholderName = "Youcef",
        maskedCardNumber = "\u2022\u2022\u2022\u2022 \u2022\u2022\u2022\u2022 \u2022\u2022\u2022\u2022 1234",
        expirationDate = "12/28",
        cardNetwork = "VISA",
        currency = "EUR"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 80.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        VirtualCardDisplay(card = defaultCard)

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Balance & Statistics",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "0.00 EUR",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "No transactions yet",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Button(
                onClick = onShowQR,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text("Show QR Code")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onShowBarcode,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text("Show Barcode")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onScanQR,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                )
            ) {
                Text("Scan QR Code")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onScanBarcode,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                )
            ) {
                Text("Scan Barcode")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onCardControls,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.tertiary
                )
            ) {
                Text("Card Controls")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onTransactions,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.tertiary
                )
            ) {
                Text("Transactions")
            }
        }
    }
}
