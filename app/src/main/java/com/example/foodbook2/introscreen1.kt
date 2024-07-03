package com.example.foodbook2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2

class introscreen1 : AppCompatActivity() {
    private lateinit var onBoardingItemAdapter: onBoardingItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introscreen1)
        val nextbutton=findViewById<Button>(R.id.nextbutton)
        nextbutton.setOnClickListener{
            val i= Intent(this, loginpage::class.java)
            startActivity(i)
        }
        onBoardingItemAdapter= onBoardingItemAdapter(
            listOf(
                onBoardingItem(
                    onBoardingImage = R.drawable.onboardinga,
                    title="All your favorites",
                    description = "Get all your loved foods in one once place,\n" +
                            "you just place the orer we do the rest"
                )
                ,
                onBoardingItem(
                    onBoardingImage = R.drawable.onboardingb,
                    title="Skip the queues and the chaos",
                    description = "No need to wait for your food while it gets prepared, SMART TIMER IS HERE!"
                ),
                onBoardingItem(
                    onBoardingImage = R.drawable.onboardingc,
                    title="Decide, Order, Pay from your table",
                    description = "Decide and order what you want at peace"
                ),
                onBoardingItem(
                    onBoardingImage = R.drawable.onboardingd,
                    title="Spend more time with your loved ones",
                    description = "No need to wait for your turn to order, order at your own ease"
                )),this
        )
        val onBoardingPageViewer=findViewById<ViewPager2>(R.id.viewpager)
        onBoardingPageViewer.adapter=onBoardingItemAdapter

    }
}