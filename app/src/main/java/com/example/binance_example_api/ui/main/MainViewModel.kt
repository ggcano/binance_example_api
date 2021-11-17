package com.example.binance_example_api.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binance_example_api.network.Repo
import com.example.binance_example_api.data.BinanceItemDTO
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel (private val repo: Repo): ViewModel() {

    var job: Job? = null
    var responseListMLD: MutableLiveData<Response<List<BinanceItemDTO>>> = MutableLiveData()


    fun getBinance() {
        viewModelScope.launch {
            val response = repo.getResponseResult()
            responseListMLD.value = response
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}