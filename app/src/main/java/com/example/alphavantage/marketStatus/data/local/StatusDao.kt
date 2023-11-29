package com.example.alphavantage.marketStatus.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StatusDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMarketStatus(
        marketStatusEntities: List<MarketStatusEntity>
    )

    @Query("DELETE FROM marketstatusentity")
    suspend fun clearMarketStatus()

    @Query("SELECT * FROM marketstatusentity")
    suspend fun marketStatuses(): List<MarketStatusEntity>
}