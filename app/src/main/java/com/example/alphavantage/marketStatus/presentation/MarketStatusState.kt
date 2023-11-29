package com.example.alphavantage.marketStatus.presentation

import com.example.alphavantage.marketStatus.domain.model.MarketStatus

data class MarketStatusState(
    val statuses: List<MarketStatus> = emptyList(),
    var isLoading: Boolean = false,
    val isRefreshing: Boolean = false
)