package com.example.alphavantage.marketStatus.presentation

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RootNavGraph(start = true)
@Destination
@Composable
fun MarketStatusScreen(
    navigator: DestinationsNavigator,
    viewModel: MarketStatusViewModel = hiltViewModel()
) {
    var state = viewModel.state
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = viewModel.state.isRefreshing)
    var lastRefreshTime by remember { mutableStateOf("") }
    val context = LocalContext.current
    val sharedPreferences by remember(context) {
        mutableStateOf(
            context.getSharedPreferences(
                "MyPrefs",
                Context.MODE_PRIVATE
            )
        )
    }

    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = {
            state = state.copy(isRefreshing = true)
            viewModel.getMarketStatus(true)
            updateLastRefreshTime(context)
            state = state.copy(isRefreshing = false)
        }) {
        val dateTime = LocalDateTime.now()
        val dateFormat = DateTimeFormatter.ofPattern("hh:mm dd:MM:yyyy")
        lastRefreshTime =
            sharedPreferences.getString("lastRefreshTime", dateTime.format(dateFormat))
                ?: dateTime.format(dateFormat)
        Column {
            Text(
                text = "Last updated: $lastRefreshTime",
                modifier = Modifier.align(CenterHorizontally)
            )
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.statuses.size) { i ->
                    if (i == 0) {
                        Text(text = "Market Type: Equity")
                    } else if (i == 14) {
                        Text(text = "Market Type: Forex")
                    } else if (i == 15) {
                        Text(text = "Market Type: Cryptocurrency")
                    }
                    MarketStatusItem(status = state.statuses[i])
                }
            }
        }
    }
}

fun updateLastRefreshTime(context: Context) {
    val sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()

    val dateTime = LocalDateTime.now()
    val dateFormat = DateTimeFormatter.ofPattern("hh:mm dd:MM:yyyy")
    val timestamp = dateTime.format(dateFormat)


    editor.putString("lastRefreshTime", timestamp)
    editor.apply()
}