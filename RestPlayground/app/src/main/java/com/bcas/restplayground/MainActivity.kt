package com.bcas.restplayground

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.bcas.restplayground.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val webService=ProductWebService.bulider()
        binding.btnGetProduct.setOnClickListener {
            getProduct(webService)
        }

    }
    private fun getProduct(webService: ProductWebService){
        val callback=object :Callback<ProductResponse>{
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                val body=response.body()
                binding.tvProduct.text=body?.title
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                //untuk melihat track error
                t.printStackTrace()
            }


        }
        webService.getProduct()
            .enqueue(callback)

    }
}