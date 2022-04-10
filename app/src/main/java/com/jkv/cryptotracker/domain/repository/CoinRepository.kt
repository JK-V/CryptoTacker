package com.jkv.cryptotracker.domain.repository

import com.jkv.cryptotracker.data.remote.dto.CoinDetailDto
import com.jkv.cryptotracker.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins() : List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}