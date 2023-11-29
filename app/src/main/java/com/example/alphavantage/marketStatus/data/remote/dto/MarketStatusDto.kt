package com.example.alphavantage.marketStatus.data.remote.dto

import com.squareup.moshi.Json

data class MarketStatusResponse(
    @field:Json(name = "endpoint") val endpoint: String,
    @field:Json(name = "markets") val markets: List<MarketStatusDto>
)

data class MarketStatusDto(
    @field:Json(name = "market_type") val marketType: String,
    @field:Json(name = "region") val region: String,
    @field:Json(name = "primary_exchanges") val primaryExchange: String,
    @field:Json(name = "current_status") val currentStatus: String,
    @field:Json(name = "local_open") val localOpen: String,
    @field:Json(name = "local_close") val localClose: String,
    @field:Json(name = "notes") val notes: String = ""
)