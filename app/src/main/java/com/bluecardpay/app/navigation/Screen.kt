package com.bluecardpay.app.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object QRCode : Screen("qr_code")
    data object Barcode : Screen("barcode")
    data object QRScanner : Screen("qr_scanner")
    data object BarcodeScanner : Screen("barcode_scanner")
    data object CardControls : Screen("card_controls")
    data object Transactions : Screen("transactions")
    data object Analytics : Screen("analytics")
    data object Settings : Screen("settings")
}
