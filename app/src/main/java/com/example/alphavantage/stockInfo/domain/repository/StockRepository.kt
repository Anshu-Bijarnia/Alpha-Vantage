package com.example.alphavantage.stockInfo.domain.repository

import com.example.alphavantage.stockInfo.domain.model.CompanyInfo
import com.example.alphavantage.stockInfo.domain.model.CompanyListing
import com.example.alphavantage.stockInfo.domain.model.IntradayInfo
import com.example.alphavantage.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {
    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>

    suspend fun getIntradayInfo(
        symbol: String
    ): Resource<List<IntradayInfo>>

    suspend fun getCompanyInfo(
        symbol: String
    ): Resource<CompanyInfo>
}