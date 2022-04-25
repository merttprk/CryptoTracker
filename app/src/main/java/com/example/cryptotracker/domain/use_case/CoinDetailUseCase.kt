package com.example.cryptotracker.domain.use_case

import com.example.cryptotracker.domain.model.Coin
import com.example.cryptotracker.domain.model.CoinDetail
import com.example.cryptotracker.domain.r_epository.CoinRepository
import com.example.cryptotracker.util.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

sealed class CoinDetailUseCase @Inject constructor(

    private val repository : CoinRepository

) {
    operator fun invoke(id:String): Flow<ResponseState<CoinDetail>> = flow {
        try{
            emit(ResponseState.Loading<CoinDetail>())
            val coinDetail =repository.getCoinByID(id).toCoinDetail()
            emit(ResponseState.Success<CoinDetail>(coinDetail))
        }
        catch (e: HttpException){
            emit(ResponseState.Error<CoinDetail>(e.localizedMessage?:"An Unexpected Error Occured"))
        }
        catch (e: IOException){
            emit(ResponseState.Error<CoinDetail>("Error Occured"))

        }
    }
}

