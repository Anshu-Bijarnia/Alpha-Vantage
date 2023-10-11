package com.example.alphavantage.stockInfo.domain.repository

import com.example.alphavantage.stockInfo.domain.model.CompanyListing
import com.example.alphavantage.stockInfo.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {
    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>
}