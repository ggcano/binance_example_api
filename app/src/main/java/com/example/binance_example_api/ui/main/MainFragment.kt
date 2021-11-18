package com.example.binance_example_api.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.binance_example_api.network.Repo
import com.example.binance_example_api.ui.adapter.DataAdapter
import com.example.binance_example_api.databinding.MainFragmentBinding
import com.example.binance_example_api.network.RetrofitService

class MainFragment : Fragment() {

    private val adapterBinance = DataAdapter()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance() = MainFragment()
        private val retrofitService = RetrofitService.getInstance()
        val mainRepository = retrofitService?.let { Repo(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        binding.recyclerMain.veil()
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
            if (response.isSuccessful) {
                response.body()?.let { adapterBinance.setListBinance(it) }
                binding.recyclerMain.unVeil()
            }else{
                println("error in response from Retrofit")
            }
        })
    }

    private fun setupRecyclerView() {
        binding.recyclerMain.apply {
            setAdapter(adapterBinance)
            setLayoutManager(LinearLayoutManager(context))
            addVeiledItems(15)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.recyclerMain.unVeil()
        _binding = null
    }

}