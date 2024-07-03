package com.example.foodbook2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.foodbook2.databinding.ActivityLoginpageBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class loginpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var auth:FirebaseAuth
        val binding=ActivityLoginpageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        auth=Firebase.auth
        var signupbutton=findViewById<Button>(R.id.signupbutton)
        signupbutton.setOnClickListener{
            val i=Intent(this, Signuppage::class.java)
            startActivity(i)
        }
        binding.loginbutton.setOnClickListener{
            val email=binding.emaileditText.text.toString()
            val password=binding.editTextPassword.text.toString()
            if(email.isBlank()||password.isBlank()){
                Toast.makeText(this,"Please fill all the fields",Toast.LENGTH_SHORT).show()
            }
            else{
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener { task->
                    if(task.isSuccessful()){
                        Toast.makeText(this,"Login Successful",Toast.LENGTH_SHORT).show()
                        val i=Intent(this,bottomviewandbanner::class.java)
                        startActivity(i)
                    }else{
                        Toast.makeText(this,"Error : ${task.exception?.message}",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}