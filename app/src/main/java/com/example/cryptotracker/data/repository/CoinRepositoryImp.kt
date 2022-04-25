package com.example.cryptotracker.data.repository

import com.example.cryptotracker.data.datasource.CoinGeckoApi
import com.example.cryptotracker.data.datasource.dto.CoinDetailDto.CoinDetailDto
import com.example.cryptotracker.data.datasource.dto.CoinListDto.CoinListDto
import com.example.cryptotracker.domain.r_epository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImp @Inject constructor(
    private val coinApi:CoinGeckoApi
) :CoinRepository{
    override suspend fun getAllCoins(page: String): CoinListDto {
        return coinApi.getAllCoins(page = page)
    }

    override suspend fun getCoinByID(id: String): CoinDetailDto {
       return coinApi.getCoinById(id= id)
    }
}