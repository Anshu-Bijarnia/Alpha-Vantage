package com.example.alphavantage.marketStatus.data.remote

import com.example.alphavantage.marketStatus.data.remote.dto.MarketStatusResponse
import com.example.alphavantage.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface StatusApi {
    @GET("query?function=MARKET_STATUS")
    suspend fun getStatus(
        @Query("apikey") apiKey: String = API_KEY
    ): MarketStatusResponse

}