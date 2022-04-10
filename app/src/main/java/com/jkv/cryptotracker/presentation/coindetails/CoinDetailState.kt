package com.jkv.cryptotracker.presentation.coindetails

import com.jkv.cryptotracker.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val errorMsg: Int = 0
)
