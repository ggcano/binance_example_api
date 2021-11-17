package com.example.binance_example_api.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.binance_example_api.Repo
import com.example.binance_example_api.adapter.DataAdapter
import com.example.binance_example_api.databinding.MainFragmentBinding
import com.example.binance_example_api.network.RetrofitService

class MainFragment : Fragment() {
    //https://api2.binance.com/api/v3/ticker/24hr
    private val adapterBinance = DataAdapter()

    companion object {
        fun newInstance() = MainFragment()
        val retrofitService = RetrofitService.getInstance()
        val mainRepository = retrofitService?.let { Repo(it) }
    }
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, MyViewModelFactory(mainRepository!!))[MainViewModel::class.java]
        setupRecyclerView()
        observables()

    }

    private fun observables(){
        viewModel.getBinance()
        viewModel.responseListMLD.observe(viewLifecycleOwner, Observer { response ->
            if (response?.isSuccessful == true) {
          adapterBinance.setListBinance(response.body()!!.toMutableList())
            }else{
                println("error")
            }
        })
    }

    private fun setupRecyclerView(){
        binding.recyclerMain.apply {
            layoutManager = LinearLayoutManager(context)
           adapter = adapterBinance
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}