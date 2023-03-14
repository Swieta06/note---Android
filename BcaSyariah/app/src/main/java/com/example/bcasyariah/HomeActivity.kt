package com.example.bcasyariah

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bcasyariah.databinding.ActivityMenuBinding
import com.example.bcasyariah.view.biodata.BiodataActivity
import com.example.bcasyariah.view.login.LoginActivity

class HomeActivity:AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
           val intent = Intent(applicationContext, BiodataActivity::class.java)
            startActivity(intent)
        }
        binding.btn2.setOnClickListener {
            val  intent=Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
        binding.btn3.setOnClickListener {
            val intent=Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}