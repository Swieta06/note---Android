package com.bcas.restplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bcas.restplayground.databinding.ActivityDetailProductBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class DetailProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailProductBinding

    @Inject
    lateinit var productWebService: ProductWebService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getIntExtra(ProductsActivity.KEY_ID,0)
        val callback = object : Callback<ProductResponse> {
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                val body = response.body()
                if (body != null){
                    Glide.with(binding.root.context)
                        .load(body.image)
                        .circleCrop()
                        .into(binding.ivDetailImage)
                    binding.tvTitleProduct.text = body.title
                    binding.tvCategoryProduct.text =  body.category
                    binding.tvDescriptionNews.text = body.description
                    binding.tvPriceProduct.text = body.price.toString()

                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                t.printStackTrace()
            }

        }
        productWebService.getSingleProduct(id).enqueue(callback)
    }
}