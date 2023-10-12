package com.example.alphavantage.stockInfo.presentation.company_listings

import com.example.alphavantage.stockInfo.domain.model.CompanyListing

data class CompanyListingsState(
    val companies: List<CompanyListing> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = ""
)
