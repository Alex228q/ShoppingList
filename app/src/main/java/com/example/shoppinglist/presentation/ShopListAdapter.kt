package com.example.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.domain.ShopItem

class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {
    var shopList = listOf<ShopItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            viewType,
            parent,
            false
        )
        return ShopItemViewHolder(view)
    }


    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val shopItem = shopList[position]
        holder.tvName.text = shopItem.name
        holder.tvCount.text = shopItem.count.toString()
        holder.itemView.setOnLongClickListener { true }
    }

    override fun getItemCount() = shopList.size

    override fun getItemViewType(position: Int): Int {
        val shopItem = shopList[position]
        return when (shopItem.enabled) {
            true -> R.layout.item_shop_enabled
            else -> R.layout.item_shop_disabled
        }
    }

    class ShopItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvCount: TextView = view.findViewById(R.id.tv_count)
        val tvName: TextView = view.findViewById(R.id.tv_name)
    }
}