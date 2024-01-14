package com.example.clone_recyclerfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clone_recyclerfragment.databinding.LayoutItemBinding

class ProductAdapter (val productItem: MutableList<ProductItem>) : RecyclerView.Adapter<ProductAdapter.Holder>() {

    interface ProductClick {
        fun onClick(view : View, position : Int)
    }
    var productClick : ProductClick? = null


    inner class Holder(val binding : LayoutItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val ivProduct = binding.ivProduct
        val tvPrice = binding.tvPrice
        val tvTime = binding.tvTime
        val tvTitle = binding.tvTitle
        val tvLoca = binding.tvLoca
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = LayoutItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  Holder(binding)
    }

    override fun getItemCount(): Int = productItem.size

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.itemView.setOnClickListener{
            productClick?.onClick(it,position)
        }

        holder.ivProduct.setImageResource(productItem[position].product)
        holder.tvPrice.text = productItem[position].price
        holder.tvTime.text = productItem[position].time
        holder.tvTitle.text = productItem[position].title
        holder.tvLoca.text = productItem[position].loca
    }
}