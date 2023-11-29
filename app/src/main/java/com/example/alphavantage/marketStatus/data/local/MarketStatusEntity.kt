package com.example.alphavantage.marketStatus.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MarketStatusEntity(
    val marketType: String,
    val region: String,
    val primaryExchange: String,
    val currentStatus: String,
    val localOpen: String,
    val localClose: String,
    val notes: String = "",
    @PrimaryKey val id: Int? = null
)
