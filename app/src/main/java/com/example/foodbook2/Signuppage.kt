package com.example.foodbook2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.foodbook2.databinding.ActivityMainBinding
import com.example.foodbook2.databinding.ActivitySignuppageBinding
import com.example.foodbook2.datamodelstore.usermodel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.oAuthProvider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database


class Signuppage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding=ActivitySignuppageBinding.inflate(layoutInflater)
        lateinit var name : String
        lateinit var email : String
        lateinit var password : String
        lateinit var repassword : String
        lateinit var database : DatabaseReference
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        var loginbutton=findViewById<Button>(R.id.loginbutton)
        var signupbutton=findViewById<Button>(R.id.signupbutton)

        var auth : FirebaseAuth = Firebase.auth
        database=Firebase.database.reference
        signupbutton.setOnClickListener{
            name=binding.nameEditText.text.toString()
            email=binding.emaileditText.text.toString()
            password=binding.passwordeditText.text.toString()
            repassword=binding.repasswordeditText.text.toString()

            if(name.isBlank()||email.isBlank()||password.isBlank()||repassword.isBlank()){
                Toast.makeText(this,"Please fill all the fields",Toast.LENGTH_SHORT).show()
            }
            if(password!=repassword){
                Toast.makeText(this,"Passwords do not match",Toast.LENGTH_SHORT).show()
            }
            else{
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                    if(task.isSuccessful()){

                        Toast.makeText(this,"Account Created Successfully ",Toast.LENGTH_SHORT).show()
                        val user=usermodel(name,email,password)
                        val userid=FirebaseAuth.getInstance().currentUser!!.uid
                        database.child("User").child(userid).setValue(user)
                        val intent=Intent(this,loginpage::class.java)
                        startActivity(intent)
                    }

                    else{

                        Toast.makeText(this,"Error occurred : ${task.exception?.message} ",Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
        loginbutton.setOnClickListener{
            val intent=Intent(this,loginpage::class.java)
            startActivity(intent)
        }
    }


}