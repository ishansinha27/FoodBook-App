package com.example.foodbook2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodbook2.R
import com.example.foodbook2.adapter.cartadapter
import com.example.foodbook2.adapter.menuitemadapter
import com.example.foodbook2.databinding.CartRecyclerviewBinding
import com.example.foodbook2.databinding.FragmentSearchBinding


class searchFragment : Fragment() {

    private lateinit var binding:FragmentSearchBinding
    private lateinit var adapter : cartadapter
    private val originalfoodname= mutableListOf("Pizza Calzone European","Chicken Burger Overloaded","Aglo E Olio Pasta","Spaghetti Carbonara")
    private val originalfoodprice= mutableListOf("Rs. 465","Rs.330","Rs.695","Rs.550")
    private val originalfoodimage= mutableListOf(R.drawable.pizzacartt,R.drawable.burgercartt, R.drawable.pastacart,R.drawable.spaghetti)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }
   private val filterMenuFoodName= mutableListOf<String>()
    private val filterMenuFoodPrice=mutableListOf<String>()
    private val filterMenuFoodImage=mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentSearchBinding.inflate(inflater,container,false)

        val foodname= listOf("Pizza Calzone European","Chicken Burger Overloaded","Aglo E Olio Pasta","Spaghetti Carbonara")
        val foodprice= listOf("Rs. 465","Rs.330","Rs.695","Rs.550")
        val foodimage= listOf(R.drawable.pizzacartt,R.drawable.burgercartt, R.drawable.pastacart,R.drawable.spaghetti)


        val adapter= cartadapter(originalfoodname,originalfoodprice,originalfoodimage)
        binding.searchrecyclerview.layoutManager= LinearLayoutManager(requireContext())
        binding.searchrecyclerview.adapter=adapter



        //Setting up search view
        setUpSearchView()
        //showall menu
        showAllMenu()


        return binding.root
    }

    private fun showAllMenu() {
        filterMenuFoodName.clear()
        filterMenuFoodPrice.clear()
        filterMenuFoodImage.clear()
        filterMenuFoodName.addAll(originalfoodname)
        filterMenuFoodPrice.addAll(originalfoodprice)
        filterMenuFoodImage.addAll(originalfoodimage)
        adapter.notifyDataSetChanged()
    }

    private fun setUpSearchView() {
        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }
    private fun filterMenuItems(query: String?) {
        filterMenuFoodName.clear()
        filterMenuFoodPrice.clear()
        filterMenuFoodImage.clear()
        originalfoodname.forEachIndexed { index, foodname ->
            if(foodname.lowercase().contains(query!!.lowercase())){
                filterMenuFoodName.add(foodname)
                filterMenuFoodPrice.add(originalfoodprice[index])
                filterMenuFoodImage.add(originalfoodimage[index])
            }
            adapter.notifyDataSetChanged()
        }


    }


    companion object {

    }
}