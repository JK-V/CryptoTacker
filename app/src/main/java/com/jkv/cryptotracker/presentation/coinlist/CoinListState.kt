package com.jkv.cryptotracker.presentation.coinlist

import com.jkv.cryptotracker.domain.model.Coin

data class CoinListState(
    val isLoading : Boolean = false,
    val coins : List<Coin> = emptyList(),
    val errorMsg : Int = 0
)
