package com.example.foodbook2.fragment

import android.content.ContentValues.TAG
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.foodbook2.R
import com.example.foodbook2.adapter.recommendadapter
import com.example.foodbook2.bottomSheetDialogMenuFragment
import com.example.foodbook2.databinding.FragmentBottomSheetDialogMenuBinding
import com.example.foodbook2.databinding.FragmentHomeBinding
import com.example.foodbook2.databinding.RecommendeditemlistBinding
import com.example.foodbook2.databinding.RestaurantmenuitemlistBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.slider.Slider


class homeFragment : Fragment() {
    lateinit var binding:FragmentHomeBinding
    lateinit var bindi:RecommendeditemlistBinding




    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        bindi = RecommendeditemlistBinding.inflate(inflater, container, false)
        bindi.restaurantopenButton.setOnClickListener{
            val bottomsheet=BottomSheetDialog(this@homeFragment.requireContext())
            val view=layoutInflater.inflate(R.layout.fragment_bottom_sheet_dialog_menu,null)
            bottomsheet.setContentView(view)
            bottomsheet.show()
        }




        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        val imageList=ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.bann,  ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.mac,  ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.subb,  ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.subbb,  ScaleTypes.FIT))

        val imageslide=binding.imageSlider
        imageslide.setImageList(imageList,ScaleTypes.FIT)
        val restaurantname= listOf<String>("Lord of the drinks","Azora", "Welcome","Tandoor Se","Indian by Heart","Pind Baluchi","Apsara", "Tawa N Tandoor")
        val restaurantimage= listOf<Int>(R.drawable.lordofdrinks,R.drawable.ress1,R.drawable.res2,R.drawable.res3,R.drawable.res4,R.drawable.res5,R.drawable.res6,R.drawable.res7)
        val cuisinee= listOf<String>("Bar - Lounge","Asian - Continental","Thai","Indian","Irani","Indian-Oriental","Chinese","Indian")
        val ratingg= listOf<String>("4.6","4.8","4.2","4.5","4.7","4.0","4.9","3.4")
        val deliveryTime= listOf<String>("25min","10min","12min","15min","25min","45min","17min","22min")
        val deliveryFee= listOf<String>("Free","Rs.10","Rs.25","Rs.25","Rs.20","Rs.55","Rs.10","Rs.25")

        val adapter=recommendadapter(restaurantimage,restaurantname,cuisinee,ratingg,deliveryTime,deliveryFee)
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.recyclerView.adapter=adapter
    }

    companion object{

    }
    }



