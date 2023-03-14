package com.bcas.myviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bcas.myviewpager.databinding.ActivityMainBinding
import com.bcas.myviewpager.fragment.CallFragment
import com.bcas.myviewpager.fragment.ChatFragment
import com.bcas.myviewpager.fragment.StatusFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var myViewPger:MyViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val chatFragment=ChatFragment()
        val statusFragment=StatusFragment()
        val callFragment=CallFragment()
        myViewPger=MyViewPagerAdapter(supportFragmentManager)
        myViewPger.addfragMen(chatFragment,"Chat")
        myViewPger.addfragMen(statusFragment,"Status")
        myViewPger.addfragMen(callFragment,"Call")
        binding.vpMain.adapter = myViewPger
        binding.tlMain.setupWithViewPager(binding.vpMain)
    }
}