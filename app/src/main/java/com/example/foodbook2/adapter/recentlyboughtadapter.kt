package com.example.foodbook2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.foodbook2.databinding.CartRecyclerviewBinding
import com.example.foodbook2.databinding.RecentlyboughtitemBinding

class recentlyboughtadapter(private val foodnameee:MutableList<String>,private val foodpriceee:MutableList<String>, private val foodimageee : MutableList<Int>) :RecyclerView.Adapter<recentlyboughtadapter.recentlyboughtviewholder>() {
    inner class recentlyboughtviewholder(private val binding: RecentlyboughtitemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int) {
            binding.apply {

                foodnamee.text = foodnameee[position]
                foodpricee.text = foodpriceee[position]
                foodimagee.setImageResource(foodimageee[position])

            }}}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recentlyboughtviewholder {
        val bind = RecentlyboughtitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return recentlyboughtviewholder(bind)
    }

    override fun getItemCount(): Int {
        return foodnameee.size
    }

    override fun onBindViewHolder(holder: recentlyboughtviewholder, position: Int) {
        holder.bind(position)
    }

}

