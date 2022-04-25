package com.example.cryptotracker.di

import com.example.cryptotracker.data.datasource.CoinGeckoApi
import com.example.cryptotracker.data.repository.CoinRepositoryImp
import com.example.cryptotracker.domain.r_epository.CoinRepository
import com.example.cryptotracker.util.Constans
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CoinGeckoModule {

    @Provides
    @Singleton
    fun provideCoinGeckoApi():CoinGeckoApi{
        return Retrofit.Builder()
            .baseUrl(Constans.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinGeckoApi::class.java)

    }
    @Provides
    @Singleton
    fun provideCoinGeckoRepository(api:CoinGeckoApi):CoinRepository{
        return CoinRepositoryImp(api)
    }
}