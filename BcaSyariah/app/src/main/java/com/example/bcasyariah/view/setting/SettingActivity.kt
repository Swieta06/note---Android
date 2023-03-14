package com.example.bcasyariah.view.setting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bcasyariah.databinding.ActivityListBinding

class SettingActivity :AppCompatActivity(){
    private lateinit var binding:ActivityListBinding
    private val settings= listOf(
        "profile","wallet","password","email","username","image profile","full name","log out"
    )
    private val settingAdapter=SettingAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.rvSimple.layoutManager=LinearLayoutManager(this)
        binding.rvSimple.adapter=settingAdapter
        settingAdapter.addItems(settings)
    }
}