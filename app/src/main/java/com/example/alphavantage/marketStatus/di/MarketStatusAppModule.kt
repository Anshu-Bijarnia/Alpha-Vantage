package com.example.alphavantage.marketStatus.di

import android.app.Application
import androidx.room.Room
import com.example.alphavantage.marketStatus.data.local.MarketStatusDatabase
import com.example.alphavantage.marketStatus.data.remote.StatusApi
import com.example.alphavantage.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MarketStatusAppModule {

    @Provides
    @Singleton
    fun provideStatusApi(): StatusApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun providesStockDatabase(app: Application): MarketStatusDatabase {
        return Room.databaseBuilder(
            app,
            MarketStatusDatabase::class.java,
            "statusdb.db"
        ).build()
    }
}