package com.example.alphavantage.stockInfo.presentation.company_info

import com.example.alphavantage.stockInfo.domain.model.CompanyInfo
import com.example.alphavantage.stockInfo.domain.model.IntradayInfo

data class CompanyInfoState(
    val stockInfos: List<IntradayInfo> = emptyList(),
    val company: CompanyInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
