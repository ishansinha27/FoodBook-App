package com.example.foodbook2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodbook2.databinding.RestaurantmenuitemlistBinding

class menuitemadapter(private val menuitemnamee:MutableList<String>,private val menuitempricee:MutableList<String>,private val menuitemdescription:MutableList<String>,private val menuitemimagee:MutableList<Int>):RecyclerView.Adapter<menuitemadapter.menuitemviewholder>() {
    inner class menuitemviewholder(private val binding: RestaurantmenuitemlistBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int){
            binding.apply {
                menuitemname.text=menuitemnamee[position]
                menuitemcost.text=menuitempricee[position]
                menuItemDescription.text=menuitemdescription[position]
                menuitemimage.setImageResource(menuitemimagee[position])
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): menuitemviewholder {
        val binditem=RestaurantmenuitemlistBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return menuitemviewholder(binditem)
    }

    override fun getItemCount(): Int {
        return menuitemnamee.size
    }

    override fun onBindViewHolder(holder: menuitemviewholder, position: Int) {
        holder.bind(position)
    }
}