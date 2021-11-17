package com.example.binance_example_api.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BinanceItemDTO(
    @SerializedName("askPrice")
    val askPrice: String,
    @SerializedName("bidPrice")
    val bidPrice: String,
    @SerializedName("bidQty")
    val bidQty: String,
    @SerializedName("closeTime")
    val closeTime: Long,
    @SerializedName("count")
    val count: Int,
    @SerializedName("firstId")
    val firstId: Int,
    @SerializedName("highPrice")
    val highPrice: String,
    @SerializedName("lastId")
    val lastId: Int,
    @SerializedName("lastPrice")
    val lastPrice: String,
    @SerializedName("lastQty")
    val lastQty: String,
    @SerializedName("lowPrice")
    val lowPrice: String,
    @SerializedName("openPrice")
    val openPrice: String,
    @SerializedName("openTime")
    val openTime: Long,
    @SerializedName("prevClosePrice")
    val prevClosePrice: String,
    @SerializedName("priceChange")
    val priceChange: String,
    @SerializedName("priceChangePercent")
    val priceChangePercent: String,
    @SerializedName("quoteVolume")
    val quoteVolume: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("volume")
    val volume: String,
    @SerializedName("weightedAvgPrice")
    val weightedAvgPrice: String
): Serializable