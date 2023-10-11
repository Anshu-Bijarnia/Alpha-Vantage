package com.example.alphavantage.stockInfo.data.mapper

import com.example.alphavantage.stockInfo.data.local.CompanyListingEntity
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