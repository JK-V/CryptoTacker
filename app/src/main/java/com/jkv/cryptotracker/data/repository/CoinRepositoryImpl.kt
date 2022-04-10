package com.jkv.cryptotracker.data.repository

import com.jkv.cryptotracker.data.remote.CoinPaprikaApis
import com.jkv.cryptotracker.data.remote.dto.CoinDetailDto
import com.jkv.cryptotracker.data.remote.dto.CoinDto
import com.jkv.cryptotracker.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    val api: CoinPaprikaApis
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}