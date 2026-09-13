package com.bluecardpay.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.bluecardpay.app.navigation.AppNavigation
import com.bluecardpay.app.ui.theme.BlueCardPayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlueCardPayTheme {
                val navController = rememberNavController()
                val app = application as BluecardPayApplication

                AppNavigation(
                    navController = navController,
                    cardRepository = app.cardRepository,
                    transactionRepository = app.transactionRepository
                )
            }
        }
    }
}
