package com.example.bcasyariah.hiltplayground

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bcasyariah.base.PreferencesHelper
import com.example.bcasyariah.databinding.ActivityInputProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProfileOverviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputProfileBinding

    @Inject
     lateinit var prefercesHelper: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.btnSave.setOnClickListener {
           val namaValue = binding.etInputNama.text
           val alamatValue = binding.etInputAlamat.text
           if (!namaValue.isNullOrEmpty() && alamatValue.isNullOrEmpty().not()) {
               prefercesHelper.saveName(namaValue.toString())
               prefercesHelper.saveAdress(alamatValue.toString())
               navigateBack()
           } else {
               Toast.makeText(this, "ISI DATA DULU YA!", Toast.LENGTH_SHORT).show()
           }
       }
    }

    private fun navigateBack() {
        startActivity(Intent(this, HiltPlaygroundActivity::class.java))
    }
}