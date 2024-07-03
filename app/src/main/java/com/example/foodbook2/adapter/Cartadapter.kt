package com.example.foodbook2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodbook2.databinding.CartRecyclerviewBinding

class cartadapter(private val foodname:MutableList<String>,private val foodprice:MutableList<String>, private val foodimage : MutableList<Int>):
    RecyclerView.Adapter<cartadapter.foodviewholder>() {
        private val itemquantities = Array(foodname.size){1}

    inner class foodviewholder(private val binding:CartRecyclerviewBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {

                cartfoodname.text = foodname[position]
                cartfoodprice.text = foodprice[position]
                cartfoodimagee.setImageResource(foodimage[position])
                quantity.text = itemquantities[position].toString()
                plusbuttoncart.setOnClickListener{
                    increaseQuantity(position)
                }
                minusbuttoncart.setOnClickListener{
                    decreasequantity(position)
                }
                deletebutton.setOnClickListener{
                    deleteitem(position)
                }
            }
        }

        fun decreasequantity(position: Int) {
            if (itemquantities[position] > 1) {
                itemquantities[position]--
                binding.quantity.text = itemquantities[position].toString()
            }
        }

        fun increaseQuantity(position: Int) {
            if (itemquantities[position] < 10) {
                itemquantities[position]++
                binding.quantity.text = itemquantities[position].toString()
            }
        }

        fun deleteitem(position: Int) {
            foodname.removeAt(position)
            foodprice.removeAt(position)
            foodimage.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, foodname.size)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): foodviewholder {
        val bind = CartRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return foodviewholder(bind)
    }

    override fun getItemCount(): Int {
        return foodname.size
    }

    override fun onBindViewHolder(holder: foodviewholder, position: Int) {
        holder.bind(position)
    }

}