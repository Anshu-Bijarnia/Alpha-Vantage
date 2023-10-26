package com.example.alphavantage.MarketStatus.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun MarketStatusScreen(
    navigator: DestinationsNavigator,
    viewModel: MarketStatusViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("MarketStatus")
    }
}