package com.jkv.cryptotracker.presentation.coinlist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jkv.cryptotracker.R
import com.jkv.cryptotracker.common.Resource
import com.jkv.cryptotracker.domain.usecase.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _coinsListState = mutableStateOf(CoinListState())
    val coinsListState: State<CoinListState> = _coinsListState

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _coinsListState.value = CoinListState(isLoading = true)
                }
                is Resource.Success -> {
                    _coinsListState.value = CoinListState(coins = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _coinsListState.value = CoinListState(errorMsg = R.string.unexpected_error_msg)
                }
            }

        }.launchIn(viewModelScope)
    }
}