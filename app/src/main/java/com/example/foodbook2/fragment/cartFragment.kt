package com.example.foodbook2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodbook2.R
import com.example.foodbook2.adapter.cartadapter
import com.example.foodbook2.databinding.FragmentCartBinding


class cartFragment : Fragment() {
    private lateinit var binding : FragmentCartBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCartBinding.inflate(inflater,container,false)
        val foodname= listOf("Pizza Calzone European","Chicken Burger Overloaded","Aglo E Olio Pasta","Spaghetti Carbonara")
        val foodprice= listOf("Rs. 465","Rs.330","Rs.695","Rs.550")
        val foodimage= listOf(R.drawable.pizzacartt,R.drawable.burgercartt, R.drawable.pastacart,R.drawable.spaghetti)
        val adapter= cartadapter(ArrayList(foodname),ArrayList(foodprice),ArrayList(foodimage))
        binding.cartrecyclerview.layoutManager= LinearLayoutManager(context)
        binding.cartrecyclerview.adapter=adapter
        return binding.root

    }

    companion object {

    }
}