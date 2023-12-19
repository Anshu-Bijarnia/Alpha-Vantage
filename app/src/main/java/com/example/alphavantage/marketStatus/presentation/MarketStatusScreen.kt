package com.example.alphavantage.marketStatus.presentation

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            LazyColumn(modifier = Modifier
                .fillMaxHeight()
                .padding(bottom = 60.dp)) {
                items(state.statuses.size) { i ->
                    if (i == 0) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "Market Type: Equity",fontSize = 25.sp)
                        Spacer(modifier = Modifier.height(15.dp))
                    } else if (i == 7) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "Market Type: Forex",fontSize = 25.sp)
                        Spacer(modifier = Modifier.height(15.dp))
                    } else if (i == 8) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "Market Type: Cryptocurrency",fontSize = 25.sp)
                        Spacer(modifier = Modifier.height(15.dp))
                    } else if (i > 8) {
                        return@items
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        if (i == 8) {
                            MarketStatusItem(status = state.statuses[15])
                        } else {
                            MarketStatusItem(status = state.statuses[i * 2])
                            if (i != 7) {
                                MarketStatusItem(status = state.statuses[i * 2 + 1])
                            }
                        }
                    }
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