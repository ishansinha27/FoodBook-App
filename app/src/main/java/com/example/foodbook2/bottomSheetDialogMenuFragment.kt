package com.example.foodbook2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodbook2.adapter.cartadapter
import com.example.foodbook2.adapter.menuitemadapter
import com.example.foodbook2.databinding.FragmentBottomSheetDialogMenuBinding


class bottomSheetDialogMenuFragment : Fragment() {
    lateinit var binding:FragmentBottomSheetDialogMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentBottomSheetDialogMenuBinding.inflate(inflater,container,false)
        val foodname= listOf("Pizza Calzone European","Chicken Burger Overloaded","Aglo E Olio Pasta","Spaghetti Carbonara")
        val foodprice= listOf("Rs. 465","Rs.330","Rs.695","Rs.550")
        val foodimage= listOf(R.drawable.pizzacartt,R.drawable.burgercartt, R.drawable.pastacart,R.drawable.spaghetti)
        val fooddescrip= listOf(" Folded Italian pizza filled with ingredients like cheese, meats, vegetables, and tomato sauce, then baked to create a crispy exterior with a warm, gooey interior.",
                "Hearty sandwich featuring a crispy or grilled chicken patty topped with a variety of extras such as cheese, bacon, lettuce, tomatoes, onions, and special sauces, all packed into a bun.",
            "Classic Italian dish made with spaghetti, garlic, olive oil, red pepper flakes, and parsley, offering a simple yet flavorful combination.",
            "Traditional Italian pasta dish made with eggs, Pecorino Romano cheese, pancetta, and black pepper, creating a rich and creamy sauce without using cream.")
        val adapter= menuitemadapter(ArrayList(foodname),ArrayList(foodprice),ArrayList(fooddescrip),ArrayList(foodimage))
        binding.menurecyclerview.layoutManager= LinearLayoutManager(context)
        binding.menurecyclerview.adapter=adapter
        return binding.root

    }

    companion object {

    }
}