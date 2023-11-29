package com.example.alphavantage.marketStatus.domain.model

data class MarketStatus(
    val marketType: String,
    val region: String,
    val primaryExchange: String,
    val currentStatus: String,
    val localOpen: String,
    val localClose: String,
    val notes: String = ""
)
