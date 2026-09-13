package com.bluecardpay.app.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.bluecardpay.app.domain.repository.CardRepository
import com.bluecardpay.app.domain.repository.TransactionRepository
import com.bluecardpay.app.ui.screens.AnalyticsScreen
import com.bluecardpay.app.ui.screens.BarcodeScreen
import com.bluecardpay.app.ui.screens.BarcodeScannerScreen
import com.bluecardpay.app.ui.screens.CardControlsScreen
import com.bluecardpay.app.ui.screens.HomeScreen
import com.bluecardpay.app.ui.screens.QRCodeScreen
import com.bluecardpay.app.ui.screens.QRScannerScreen
import com.bluecardpay.app.ui.screens.SettingsScreen
import com.bluecardpay.app.ui.screens.TransactionsScreen

@Composable
fun AppNavigation(
    navController: NavHostController,
    cardRepository: CardRepository,
    transactionRepository: TransactionRepository
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (isBottomNavVisible(currentRoute)) {
                BottomNavigationBar(navController, currentRoute)
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    cardRepository = cardRepository,
                    transactionRepository = transactionRepository,
                    onShowQR = { navController.navigate(Screen.QRCode.route) },
                    onShowBarcode = { navController.navigate(Screen.Barcode.route) },
                    onScanQR = { navController.navigate(Screen.QRScanner.route) },
                    onScanBarcode = { navController.navigate(Screen.BarcodeScanner.route) },
                    onCardControls = { navController.navigate(Screen.CardControls.route) },
                    onTransactions = { navController.navigate(Screen.Transactions.route) }
                )
            }

            composable(Screen.QRCode.route) {
                QRCodeScreen(
                    onBack = { navController.popBackStack() },
                    onRefresh = {}
                )
            }

            composable(Screen.Barcode.route) {
                BarcodeScreen(
                    onBack = { navController.popBackStack() },
                    onRefresh = {}
                )
            }

            composable(Screen.QRScanner.route) {
                QRScannerScreen(
                    onCancel = { navController.popBackStack() },
                    onScanComplete = { navController.popBackStack() }
                )
            }

            composable(Screen.BarcodeScanner.route) {
                BarcodeScannerScreen(
                    onCancel = { navController.popBackStack() },
                    onScanComplete = { navController.popBackStack() }
                )
            }

            composable(Screen.CardControls.route) {
                CardControlsScreen(
                    onBack = { navController.popBackStack() }
                )
            }

            composable(Screen.Transactions.route) {
                TransactionsScreen(
                    transactionRepository = transactionRepository,
                    onBack = { navController.popBackStack() }
                )
            }

            composable(Screen.Analytics.route) {
                AnalyticsScreen(
                    transactionRepository = transactionRepository,
                    onBack = { navController.popBackStack() }
                )
            }

            composable(Screen.Settings.route) {
                SettingsScreen(
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}

@Composable
private fun BottomNavigationBar(
    navController: NavController,
    currentRoute: String?
) {
    NavigationBar {
        NavigationBarItem(
            icon = { Text("🏠") },
            label = { Text("Home") },
            selected = currentRoute == Screen.Home.route,
            onClick = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Home.route) { inclusive = true }
                }
            }
        )

        NavigationBarItem(
            icon = { Text("📊") },
            label = { Text("Activity") },
            selected = currentRoute == Screen.Analytics.route,
            onClick = {
                navController.navigate(Screen.Analytics.route)
            }
        )

        NavigationBarItem(
            icon = { Text("📱") },
            label = { Text("Scan") },
            selected = currentRoute == Screen.QRScanner.route || currentRoute == Screen.BarcodeScanner.route,
            onClick = {
                navController.navigate(Screen.QRScanner.route)
            }
        )

        NavigationBarItem(
            icon = { Text("💳") },
            label = { Text("Card") },
            selected = currentRoute == Screen.CardControls.route,
            onClick = {
                navController.navigate(Screen.CardControls.route)
            }
        )

        NavigationBarItem(
            icon = { Text("⚙️") },
            label = { Text("Settings") },
            selected = currentRoute == Screen.Settings.route,
            onClick = {
                navController.navigate(Screen.Settings.route)
            }
        )
    }
}

private fun isBottomNavVisible(currentRoute: String?): Boolean {
    return currentRoute in listOf(
        Screen.Home.route,
        Screen.Analytics.route,
        Screen.CardControls.route,
        Screen.Settings.route
    )
}
