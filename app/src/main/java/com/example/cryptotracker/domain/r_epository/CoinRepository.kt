package com.example.cryptotracker.domain.r_epository

import com.example.cryptotracker.data.datasource.dto.CoinDetailDto.CoinDetailDto
import com.example.cryptotracker.data.datasource.dto.CoinListDto.CoinListDto

interface CoinRepository {

    suspend fun getAllCoins(page:String):CoinListDto

    suspend fun getCoinByID(id:String):CoinDetailDto
}