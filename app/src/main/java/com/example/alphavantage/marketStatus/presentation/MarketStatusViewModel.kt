package com.example.alphavantage.marketStatus.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alphavantage.marketStatus.domain.repository.StatusRepository
import com.example.alphavantage.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarketStatusViewModel @Inject constructor(
    private val repository: StatusRepository
) : ViewModel() {
    var state by mutableStateOf(MarketStatusState())

    init {
        getMarketStatus()
    }

    fun getMarketStatus(
        fetchFromRemote: Boolean = false
    ) {
        viewModelScope.launch {
            repository
                .getMarketStatus(fetchFromRemote)
                .collect {
                    when (it) {
                        is Resource.Success -> {
                            it.data?.let { status ->
                                state = state.copy(
                                    statuses = status
                                )
                            }
                        }

                        is Resource.Error -> Unit
                        is Resource.Loading -> {
                            state = state.copy(isLoading = it.isLoading)
                        }
                    }
                }
        }
    }
}