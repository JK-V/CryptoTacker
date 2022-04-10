package com.jkv.cryptotracker.di

import com.jkv.cryptotracker.common.Constants
import com.jkv.cryptotracker.data.remote.CoinPaprikaApis
import com.jkv.cryptotracker.data.repository.CoinRepositoryImpl
import com.jkv.cryptotracker.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApis {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun getCoinRepository(api: CoinPaprikaApis): CoinRepository {
        return CoinRepositoryImpl(
            api
        )
    }
}