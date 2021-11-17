package com.example.binance_example_api.network
import com.example.binance_example_api.data.BinanceItemDTO
import retrofit2.Response

class Repo constructor(private val retrofitService: RetrofitService) {

    private val urlString: String = "ticker/24hr"

    suspend fun getResponseResult(): Response<List<BinanceItemDTO>> {
        return retrofitService.getListBinance(urlString)
    }
}