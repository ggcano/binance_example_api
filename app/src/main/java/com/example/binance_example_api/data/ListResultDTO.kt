package com.example.binance_example_api.data

import com.google.gson.annotations.SerializedName

data class ListResultDTO (
    @SerializedName("")
    val list: ArrayList<BinanceItemDTO>
)