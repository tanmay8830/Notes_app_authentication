package com.example.notes_app_authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notes_app_authentication.databinding.ActivityLoginBinding

class Login_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var databaseDBHelper: databaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        databaseDBHelper = databaseHelper(this)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseDBHelper = databaseHelper(this)
        binding.Loginbutton.setOnClickListener {
            val loginusername = binding.Loginusername.text.toString()
            val loginpassword = binding.Loginpassword.text.toString()
            loginDatabase(loginusername, loginpassword)
        }
        binding.Signupredirect.setOnClickListener {
            val intent = Intent(this ,Signup_Activity::class.java)
            startActivity(intent)
            finish()

        }
    }


        private fun loginDatabase(username:String , password:String){
            val userExists = databaseDBHelper.readuser(username, password)
            if (userExists){
                Toast.makeText(this, "Login Successful" , Toast.LENGTH_SHORT).show()
                val intent = Intent(this , MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "Login falied" , Toast.LENGTH_SHORT).show()
            }
        }
    }
