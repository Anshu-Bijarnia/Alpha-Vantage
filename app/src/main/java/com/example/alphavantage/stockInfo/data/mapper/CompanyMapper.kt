package com.example.alphavantage.stockInfo.data.mapper

import com.example.alphavantage.stockInfo.data.local.CompanyListingEntity
import com.example.alphavantage.stockInfo.data.remote.dto.CompanyInfoDto
import com.example.alphavantage.stockInfo.domain.model.CompanyInfo
import com.example.alphavantage.stockInfo.domain.model.CompanyListing

fun CompanyListingEntity.toCompanyListing(): CompanyListing {
    return CompanyListing(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyListing.toCompanyListingEntity(): CompanyListingEntity {
    return CompanyListingEntity(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyInfoDto.toCompanyInfo(): CompanyInfo {
    return CompanyInfo(
        symbol = symbol ?: "",
        description = description ?: "",
        name = name ?: "",
        industry = industry ?: "",
        country = country ?: ""
    )
}