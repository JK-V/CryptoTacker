package com.jkv.cryptotracker.domain.usecase

import com.jkv.cryptotracker.common.Resource
import com.jkv.cryptotracker.data.remote.CoinPaprikaApis
import com.jkv.cryptotracker.data.remote.dto.toCoin
import com.jkv.cryptotracker.domain.model.Coin
import com.jkv.cryptotracker.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage))
        }
    }
}