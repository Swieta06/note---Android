package com.bcas.zwallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bcas.zwallet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val transactionAdapter=TransactionAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding=ActivityMainBinding.inflate(layoutInflater)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMain.layoutManager= LinearLayoutManager(this)
        binding.rvMain.adapter=transactionAdapter
        transactionAdapter.addNewItem(DataSources.transactionList)

//        binding.cardContent.setTitle("mario")
//        binding.cardContent.setSubTitle("Transfer")
//        binding.cardContent.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSgP6_S6_wUdmCBuiXitghmQBGdYd-pBSKJiA&usqp=CAU")
//        binding.cardContent2.setTitle("maio")
//        binding.cardContent2.setSubTitle("Transfer")
//        binding.cardContent2.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSgP6_S6_wUdmCBuiXitghmQBGdYd-pBSKJiA&usqp=CAU")
    }
}