package com.jkv.cryptotracker.presentation

sealed class Screen(
    val route: String
) {
    object CoinListScreen : Screen("CoinListScreen")
    object CoinDetailScreen : Screen("CoinDetailScreen")
}
