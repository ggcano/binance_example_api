package com.example.binance_example_api.network

import com.example.binance_example_api.data.BinanceDTO
import com.example.binance_example_api.data.BinanceItemDTO
import com.example.binance_example_api.data.ListResultDTO
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

interface RetrofitService {

    @GET
    suspend fun getListBinance (@Url url:String): Response<List<BinanceItemDTO>>

    companion object {
        var retrofitService: RetrofitService? = null
        fun getInstance() : RetrofitService? {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api2.binance.com/api/v3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService
        }

    }
}