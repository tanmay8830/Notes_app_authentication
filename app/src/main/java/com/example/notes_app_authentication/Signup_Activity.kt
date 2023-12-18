package com.example.notes_app_authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notes_app_authentication.databinding.ActivitySignupBinding

class Signup_Activity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    private lateinit var databaseHelper:databaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = databaseHelper(this)
        binding.signupbutton.setOnClickListener {
            val signupUsername = binding.Signuseredittext.text.toString()
            val signupUserpassword = binding.passwordsignup.text.toString()


            signupDB(signupUsername,signupUserpassword)
        }
        binding.Loginredirect.setOnClickListener {
            val intent = Intent(this,Login_Activity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun signupDB(username: String, password: String){
        val insertRowId = databaseHelper.insertUser(username,password)
        if (insertRowId != -1L){
            Toast.makeText(this,"Signup Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,Login_Activity::class.java)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this,"Signup failed", Toast.LENGTH_SHORT).show()
        }
    }
}