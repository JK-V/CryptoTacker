package com.jkv.cryptotracker.data.remote

import com.jkv.cryptotracker.data.remote.dto.CoinDetailDto
import com.jkv.cryptotracker.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApis {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}