package com.example.binance_example_api.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import coil.transform.CircleCropTransformation
import com.example.binance_example_api.R
import com.example.binance_example_api.data.BinanceItemDTO
import com.example.binance_example_api.databinding.ItemViewBinding
import java.text.SimpleDateFormat

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
        val format = SimpleDateFormat("yyyy-MM-dd -- HH:mm:ss")
        val binance = listBinance[position]
        val percentBinance = binance.priceChangePercent
        val symbolImagelast: String = binance.symbol.dropLast(3)
        val symbolImageFirst: String = binance.symbol.drop(3)
        holder.binding.textView1.text = binance.symbol
        holder.binding.textView2.text = format.format(binance.openTime)
        holder.binding.textView3.text = binance.lastPrice
        holder.binding.textViewPercent.text = binance.priceChangePercent + " %"
        if (percentBinance.toFloat() <= 0) {
            holder.binding.textViewPercent.setTextColor(Color.RED)
        } else{
            holder.binding.textViewPercent.setTextColor(Color.GREEN)
        }
        //Load Images
        val imageLoader = ImageLoader.Builder(holder.itemView.context)
            .componentRegistry {
                add(SvgDecoder(holder.itemView.context))
            }
            .build()
            Coil.setImageLoader(imageLoader)
            holder.binding.imageView.load("https://s3-symbol-logo.tradingview.com/crypto/XTVC$symbolImagelast--big.svg"){
                transformations(CircleCropTransformation())
            }
            holder.binding.imageToBinance.load("https://s3-symbol-logo.tradingview.com/crypto/XTVC$symbolImageFirst--big.svg"){
                transformations(CircleCropTransformation())
            }
            }

    }