package com.jkv.cryptotracker.presentation.coindetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jkv.cryptotracker.R
import com.jkv.cryptotracker.common.Constants
import com.jkv.cryptotracker.common.Resource
import com.jkv.cryptotracker.domain.model.CoinDetail
import com.jkv.cryptotracker.domain.usecase.GetCoinByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinByIdUseCase: GetCoinByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _coinDetailState = mutableStateOf(CoinDetailState())
    val coinDetailState: State<CoinDetailState> = _coinDetailState

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let {
            getCoinById(it)
        }
    }

    private fun getCoinById(coinId: String) {
        getCoinByIdUseCase(coinId = coinId).onEach {
            when (it) {
                is Resource.Loading -> {
                    _coinDetailState.value = CoinDetailState(isLoading = true)
                }
                is Resource.Success -> {
                    _coinDetailState.value = CoinDetailState(coin = it.data)
                }
                is Resource.Error -> {
                    _coinDetailState.value =
                        CoinDetailState(errorMsg = R.string.unexpected_error_msg)
                }
            }
        }.launchIn(viewModelScope)
    }
}