package com.example.foodbook2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splash01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash01)
        Handler().postDelayed({
            val i = Intent(this,introscreen1::class.java)
            startActivity(i)
            finish()
        },2000)
    }
}