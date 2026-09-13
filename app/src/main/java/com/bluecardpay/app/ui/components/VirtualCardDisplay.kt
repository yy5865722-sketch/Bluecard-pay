package com.bluecardpay.app.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bluecardpay.app.domain.model.Card

@Composable
fun VirtualCardDisplay(
    card: Card,
    isFlipped: Boolean = false,
    modifier: Modifier = Modifier
) {
    val rotation by animateFloatAsState(targetValue = if (isFlipped) 180f else 0f)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .graphicsLayer { rotationY = rotation }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "BlueCard Pay",
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = card.maskedCardNumber,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 18.sp,
                    letterSpacing = 2.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "Cardholder",
                            color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f),
                            fontSize = 10.sp
                        )
                        Text(
                            text = card.cardholderName,
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Column {
                        Text(
                            text = "Expires",
                            color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f),
                            fontSize = 10.sp
                        )
                        Text(
                            text = card.expirationDate,
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Box(
                        modifier = Modifier
                            .background(
                                MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.2f),
                                RoundedCornerShape(4.dp)
                            )
                            .padding(4.dp)
                    ) {
                        Text(
                            text = card.cardNetwork,
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}
