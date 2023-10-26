package com.example.alphavantage.currencyEx.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun CurrencyExchangeScreen(
    navigator: DestinationsNavigator,
    viewModel: CurrencyExchangeViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "CurrencyExchange screen")
    }
}