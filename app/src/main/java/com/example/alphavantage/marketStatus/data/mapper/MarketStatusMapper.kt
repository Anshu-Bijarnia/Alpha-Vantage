package com.example.alphavantage.marketStatus.data.mapper

import com.example.alphavantage.marketStatus.data.local.MarketStatusEntity
import com.example.alphavantage.marketStatus.data.remote.dto.MarketStatusDto
import com.example.alphavantage.marketStatus.domain.model.MarketStatus

fun MarketStatusEntity.toMarketStatus(): MarketStatus {
    return MarketStatus(
        marketType = marketType,
        region = region,
        primaryExchange = primaryExchange,
        currentStatus = currentStatus,
        localOpen = localOpen,
        localClose = localClose,
        notes = notes
    )
}

fun MarketStatus.toMarketStatusEntity(): MarketStatusEntity {
    return MarketStatusEntity(
        marketType = marketType,
        region = region,
        primaryExchange = primaryExchange,
        currentStatus = currentStatus,
        localOpen = localOpen,
        localClose = localClose,
        notes = notes
    )
}

fun MarketStatusDto.toMarketStatus(): MarketStatus {
    return MarketStatus(
        marketType = marketType ?: "",
        region = region ?: "",
        primaryExchange = primaryExchange ?: "",
        currentStatus = currentStatus ?: "",
        localOpen = localOpen ?: "",
        localClose = localClose ?: "",
        notes = notes ?: ""
    )
}