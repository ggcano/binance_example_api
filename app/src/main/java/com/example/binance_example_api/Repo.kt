package com.example.binance_example_api

import com.example.binance_example_api.data.BinanceDTO
import com.example.binance_example_api.data.BinanceItemDTO
import com.example.binance_example_api.data.ListResultDTO
import com.example.binance_example_api.network.RetrofitService
import retrofit2.Response

class Repo constructor(private val retrofitService: RetrofitService) {

    private val urlString: String = "ticker/24hr"

    suspend fun getResponseResult(): Response<List<BinanceItemDTO>>? {
        return retrofitService.getListBinance(urlString)
    }
}