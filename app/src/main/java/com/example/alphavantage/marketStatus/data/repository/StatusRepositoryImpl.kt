package com.example.alphavantage.marketStatus.data.repository

import android.util.Log
import com.example.alphavantage.marketStatus.data.local.MarketStatusDatabase
import com.example.alphavantage.marketStatus.data.mapper.toMarketStatus
import com.example.alphavantage.marketStatus.data.mapper.toMarketStatusEntity
import com.example.alphavantage.marketStatus.data.remote.StatusApi
import com.example.alphavantage.marketStatus.domain.model.MarketStatus
import com.example.alphavantage.marketStatus.domain.repository.StatusRepository
import com.example.alphavantage.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StatusRepositoryImpl @Inject constructor(
    private val api: StatusApi,
    private val db: MarketStatusDatabase
) : StatusRepository {

    private val dao = db.dao
    override suspend fun getMarketStatus(
        fetchFromRemote: Boolean
    ): Flow<Resource<List<MarketStatus>>> {
        return flow {
            emit(Resource.Loading(true))
            val localStatuses = dao.marketStatuses()
            emit(
                Resource.Success(
                    data = localStatuses.map { it.toMarketStatus() }
                ))

            val isDbEmpty = localStatuses.isEmpty()
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote
            if (shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                Log.d("API", "Loaded from cache")
                return@flow
            }
            val remoteStatus = try {
                Log.d("API", "Loaded from remote")
                val response = api.getStatus()
                response.markets
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            }
            remoteStatus?.let { status ->
                dao.clearMarketStatus()
                dao.insertMarketStatus(
                    status.map { it.toMarketStatus().toMarketStatusEntity() }
                )
                emit(
                    Resource.Success(
                        data = dao
                            .marketStatuses()
                            .map { it.toMarketStatus() })
                )
                emit(Resource.Loading(false))
            }
        }
    }
}