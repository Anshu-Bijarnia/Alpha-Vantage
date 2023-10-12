package com.example.alphavantage.stockInfo.di

import com.example.alphavantage.stockInfo.data.csv.CSVParser
import com.example.alphavantage.stockInfo.data.csv.CompanyListingsParser
import com.example.alphavantage.stockInfo.data.csv.IntradayInfoParser
import com.example.alphavantage.stockInfo.data.repository.StockRepositoryImpl
import com.example.alphavantage.stockInfo.domain.model.CompanyListing
import com.example.alphavantage.stockInfo.domain.model.IntradayInfo
import com.example.alphavantage.stockInfo.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingsParser(
        companyListingsParser: CompanyListingsParser
    ): CSVParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindIntradayInfoParser(
        intradayInfoParser: IntradayInfoParser
    ): CSVParser<IntradayInfo>

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepositoryImpl: StockRepositoryImpl
    ): StockRepository
}