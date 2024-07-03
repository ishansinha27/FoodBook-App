package com.example.foodbook2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodbook2.databinding.RecommendeditemlistBinding

class recommendadapter(private val restaurantImage:List<Int>,private val restaurantName:List<String>,private val cuisine:List<String>,private val rating:List<String>,private val deliveryfee:List<String>,private val deliverytime:List<String>): RecyclerView.Adapter<recommendadapter.recommendviewholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recommendviewholder {
        return recommendviewholder(RecommendeditemlistBinding.inflate(LayoutInflater.from(parent.context),parent,false ))
    }

    override fun getItemCount(): Int {
        return restaurantName.size
    }

    override fun onBindViewHolder(holder: recommendviewholder, position: Int) {
        val restaurantimage=restaurantImage[position]
        val restaurantname=restaurantName[position]
        val cuisinee=cuisine[position]
        val ratingg=rating[position]
        val deliveryTime=deliverytime[position]
        val deliveryFee=deliveryfee[position]
        holder.bind(restaurantname,restaurantimage,cuisinee,ratingg,deliveryTime,deliveryFee)
    }
    class recommendviewholder(private val binding : RecommendeditemlistBinding ):RecyclerView.ViewHolder(binding.root){
        private val restimages=binding.restaurantImage
        private val restaurantOpenButton=binding.restaurantopenButton

        fun bind(restaurantname: String, restaurantimage: Int, cuisinee: String, ratingg: String, deliveryTime: String, deliveryFee: String) {

            binding.restaurantName.text= restaurantname.toString()
            binding.cuisine.text=cuisinee
            binding.rating.text=ratingg
            binding.deliverytime.text=deliveryTime
            binding.deliveryfee.text=deliveryFee
            restimages.setImageResource(restaurantimage)

        }




    }
}