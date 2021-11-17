package com.example.binance_example_api.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.binance_example_api.R
import com.example.binance_example_api.data.BinanceItemDTO
import com.example.binance_example_api.databinding.ItemViewBinding

class DataAdapter : RecyclerView.Adapter<DataAdapter.MainViewHolder>() {

    private var listBinance = mutableListOf<BinanceItemDTO>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemViewBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listBinance.size
    }

  fun setListBinance(listResult: MutableList<BinanceItemDTO>){
      this.listBinance = listResult
      notifyDataSetChanged()
  }

    class MainViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val binance = listBinance[position]
        holder.binding.textView1.text = binance.openPrice
        holder.binding.textView2.text = binance.symbol
    }
}