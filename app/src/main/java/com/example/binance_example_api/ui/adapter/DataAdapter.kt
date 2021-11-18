package com.example.binance_example_api.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.binance_example_api.R
import com.example.binance_example_api.data.BinanceItemDTO
import com.example.binance_example_api.databinding.ItemViewBinding
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class DataAdapter : RecyclerView.Adapter<DataAdapter.MainViewHolder>() {

    private var listBinance = listOf<BinanceItemDTO>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemViewBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listBinance.size
    }

    fun setListBinance(listResult: List<BinanceItemDTO>) {
        this.listBinance = listResult
        notifyDataSetChanged()
    }

    class MainViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root){

    }


    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val format = SimpleDateFormat("HH:mm  --  yyyy.MM.dd")
        val binance = listBinance[position]
        holder.binding.textView1.text = binance.symbol
        holder.binding.textView2.text = format.format(binance.openTime)
        holder.binding.textView3.text = binance.priceChange
        Glide.with(holder.itemView.context).
        load("https://www.totalcoin.io/uploads/news/u9/2018/01/binance-logo.png")
            .into(holder.binding.imageView)
    }
}