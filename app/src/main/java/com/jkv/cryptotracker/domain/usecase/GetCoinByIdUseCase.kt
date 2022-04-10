package com.jkv.cryptotracker.domain.usecase

import com.jkv.cryptotracker.common.Resource
import com.jkv.cryptotracker.data.remote.dto.toCoinDetails
import com.jkv.cryptotracker.domain.model.CoinDetail
import com.jkv.cryptotracker.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinByIdUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coinDetail = repository.getCoinById(coinId = coinId).toCoinDetails()
            emit(Resource.Success<CoinDetail>(coinDetail))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage))
        } catch (e: IOException) {
            emit((Resource.Error<CoinDetail>(e.localizedMessage)))
        }
    }
}