package com.example.spendingmaster

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.spendingmaster.databinding.SplashScreenBinding

class LoginPage: AppCompatActivity() {

        private lateinit var binding: SplashScreenBinding
        private lateinit var appLoginButton : Button


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = SplashScreenBinding.inflate(layoutInflater)
            setContentView(binding.root)

            appLoginButton = findViewById(R.id.appLoginButton)

            appLoginButton.setOnClickListener {
                //aktivity'ler arası geçiş yapacağımız için intent nesnesini kullandım
                val intent = Intent(this@LoginPage , MainActivity::class.java)
                startActivity(intent)
            }
        }

}