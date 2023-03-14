package com.example.bcasyariah.view.biodata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bcasyariah.databinding.ActivityBiodataBinding

class BiodataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBiodataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBiodataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val names="hello"
        val age=30
        val gender="female"
        val email="female@gmail.com"
        val address="cikarang barat"
        val phone="0888888888"
        val religion="muslim"
        val job="IT Trainee"
        binding.name.text=names
        binding.age.text=age.toString()
        binding.gender.text=gender
        binding.email.text=email
        binding.address.text=address
        binding.phone.text=phone
        binding.religion.text=religion
        binding.job.text=job
        //name.text=names.toString()
        //var name="John Doe"
        //Toast.makeText(applicationContext,name,Toast.LENGTH_LONG).show()

    }
}