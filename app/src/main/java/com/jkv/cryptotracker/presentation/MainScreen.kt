package com.jkv.cryptotracker.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jkv.cryptotracker.presentation.coindetails.CoinDetailScreen
import com.jkv.cryptotracker.presentation.coinlist.CoinListScreen

@Composable
fun MainScreen(toggleTheme: () -> Unit) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.CoinListScreen.route
    ) {
        composable(
            route = Screen.CoinListScreen.route
        ) {

            CoinListScreen(
                navController,
                toggleTheme = toggleTheme
            )
        }
        composable(
            route = Screen.CoinDetailScreen.route + "/{coinId}"
        ) {
            CoinDetailScreen()
        }
    }
}