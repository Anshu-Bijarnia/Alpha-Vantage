package com.example.alphavantage.marketStatus.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MarketStatusEntity::class],
    version = 1
)
abstract class MarketStatusDatabase : RoomDatabase() {
    abstract val dao: StatusDao
}