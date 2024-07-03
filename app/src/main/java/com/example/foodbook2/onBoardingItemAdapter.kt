package com.example.foodbook2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder



class onBoardingItemAdapter(private val onBoardingItemlist : List<onBoardingItem>, var context: Context):
    RecyclerView.Adapter<onBoardingItemAdapter.onBoardingItemViewHolder>() {
    inner class onBoardingItemViewHolder(view:View): RecyclerView.ViewHolder(view){
        private val imageOnboarding=view.findViewById<ImageView>(R.id.imageView2)
        private val textTitle=view.findViewById<TextView>(R.id.textView2)
        private val textDescription=view.findViewById<TextView>(R.id.textView3)

        fun bind(onBoardingItem: onBoardingItem){
            imageOnboarding.setImageResource(onBoardingItem.onBoardingImage)
            textTitle.text=onBoardingItem.title
            textDescription.text=onBoardingItem.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): onBoardingItemViewHolder {
        var view= LayoutInflater.from(context).inflate(R.layout.onboardingscreenlayout,parent,false)
        return onBoardingItemViewHolder(view)

    }

    override fun getItemCount(): Int {
        return onBoardingItemlist.size
    }

    override fun onBindViewHolder(holder: onBoardingItemViewHolder, position: Int) {
        holder.bind(onBoardingItemlist[position])
    }
}