package com.example.alphavantage.marketStatus.di

import com.example.alphavantage.marketStatus.data.repository.StatusRepositoryImpl
import com.example.alphavantage.marketStatus.domain.repository.StatusRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MarketStatusRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindMarketStatusRepository(
        marketStatusRepositoryImpl: StatusRepositoryImpl
    ): StatusRepository
}