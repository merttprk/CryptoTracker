package com.example.cryptotracker.data.datasource.dto.CoinDetailDto

import com.example.cryptotracker.domain.model.CoinDetail

data class CoinDetailDto(
    val additional_notices: List<Any>,
    val asset_platform_id: Any,
    val block_time_in_minutes: Int,
    val categories: List<String>,
    val coingecko_rank: Int,
    val coingecko_score: Double,
    val community_data: CommunityData,
    val community_score: Double,
    val country_origin: String,
    val description: Description,
    val developer_data: DeveloperData,
    val developer_score: Double,
    val genesis_date: String,
    val hashing_algorithm: String,
    val id: String,
    val image: İmage,
    val last_updated: String,
    val links: Links,
    val liquidity_score: Double,
    val localization: Localization,
    val market_cap_rank: Int,
    val market_data: MarketData,
    val name: String,
    val platforms: Platforms,
    val public_interest_score: Int,
    val public_interest_stats: PublicİnterestStats,
    val public_notice: Any,
    val sentiment_votes_down_percentage: Double,
    val sentiment_votes_up_percentage: Double,
    val status_updates: List<Any>,
    val symbol: String,
    val tickers: List<Ticker>
){
    fun toCoinDetail():CoinDetail{
        return CoinDetail(
            name=name,
            image = image.large,
            market_cap = market_data.market_cap.usd.toDouble(),
            price = market_data.current_price.usd.toDouble(),
            price_percentage_change = market_data.market_cap_change_percentage_24h,
            low_price = market_data.low_24h.usd.toDouble(),
            high_price = market_data.high_24h.usd.toDouble(),
            description = description.en,

        )
    }
}