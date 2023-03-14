package com.example.bcasyariah.view.LatihanFragmen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bcasyariah.R
import com.example.bcasyariah.databinding.HostActivityBinding
import com.example.bcasyariah.view.LatihanFragmen.InputBiodata.InputBiodataFragment
import com.example.bcasyariah.view.LatihanFragmen.home.HomeFrament

class HostActivity : AppCompatActivity() {
    private lateinit var binding: HostActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HostActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBiodataFragment()

    }

    private fun initBiodataFragment() {
        val inputBiodataFragment = HomeFrament()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, inputBiodataFragment)
            .commit()
    }
}