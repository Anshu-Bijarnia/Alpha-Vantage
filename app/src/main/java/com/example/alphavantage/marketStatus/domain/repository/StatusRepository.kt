package com.example.alphavantage.marketStatus.domain.repository

import com.example.alphavantage.marketStatus.domain.model.MarketStatus
import com.example.alphavantage.util.Resource
import kotlinx.coroutines.flow.Flow

interface StatusRepository {
    suspend fun getMarketStatus(
        fetchFromRemote: Boolean
    ): Flow<Resource<List<MarketStatus>>>
}