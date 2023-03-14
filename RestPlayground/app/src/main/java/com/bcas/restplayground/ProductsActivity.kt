package com.bcas.restplayground

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.bcas.restplayground.databinding.ActivityProductsBinding
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class ProductsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductsBinding
    private val productsAdapter = ProductAdapter()

    @Inject
    lateinit var productService: ProductWebService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        // val productService = ProductWebService.bulider()
        val callback = object : Callback<List<ProductResponse>> {
            override fun onResponse(
                call: Call<List<ProductResponse>>,
                response: Response<List<ProductResponse>>
            ) {
                val body = response.body()
                if (body != null) {
                    binding.pbProducts.isVisible = false
                    productsAdapter.addNewProducts(body)
                }
            }

            override fun onFailure(call: Call<List<ProductResponse>>, t: Throwable) {
                t.printStackTrace()
            }
        }
        productService.getProducts().enqueue(callback)

    }

    private fun setupRecyclerView() {
        binding.rvProducts.layoutManager = LinearLayoutManager(this)
        binding.rvProducts.adapter = productsAdapter
        productsAdapter.onClickProduct {
            val intent=Intent(applicationContext, DetailProductActivity::class.java)
            intent.putExtra(KEY_ID,it.id)
            startActivity(intent)
        }
    }
    companion object{
        const val KEY_ID="id"
    }
}