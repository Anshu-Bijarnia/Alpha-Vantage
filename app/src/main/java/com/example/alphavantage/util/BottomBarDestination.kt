package com.example.alphavantage.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CurrencyExchange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.alphavantage.destinations.CompanyListingsScreenDestination
import com.example.alphavantage.destinations.CurrencyExchangeScreenDestination
import com.example.alphavantage.destinations.MarketStatusScreenDestination
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec

enum class BottomBarDestination(
    val direction: DirectionDestinationSpec,
    val icon: ImageVector,
    val label: String
) {
    MarketStatusScreen(MarketStatusScreenDestination, Icons.Default.Home, "Market Status"),
    CompanyListingScreen(CompanyListingsScreenDestination, Icons.Default.List, "Company Listing"),
    CurrencyExchangeScreen(
        CurrencyExchangeScreenDestination,
        Icons.Default.CurrencyExchange,
        "Currency Exchange"
    )
}