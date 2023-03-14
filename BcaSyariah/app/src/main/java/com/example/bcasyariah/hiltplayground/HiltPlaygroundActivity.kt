package com.example.bcasyariah.hiltplayground

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bcasyariah.base.PreferencesHelper

import com.example.bcasyariah.databinding.ActivityHiltPlaygroundBinding
import com.example.bcasyariah.model.Engine
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HiltPlaygroundActivity : AppCompatActivity() {
    private var _binding: ActivityHiltPlaygroundBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var perferenceHelper: PreferencesHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHiltPlaygroundBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateValueLayout()
        binding.btnSave.setOnClickListener {
            val intent = Intent(this, ProfileOverviewActivity::class.java)
            startActivity(intent)
        }
        binding.btnClearPref.setOnClickListener {
            perferenceHelper.clearDataPref()
            updateValueLayout()
        }
//        engine.startEngine()
//        var engine = Engine()
//        engine.startEngine()
    }

    private fun updateValueLayout() {
        val getNameFromLocal = perferenceHelper.getName()
        val getAddressFromLocal = perferenceHelper.getAdress()
        binding.tvName.text = getNameFromLocal
        binding.tvLocation.text = getAddressFromLocal
    }
}