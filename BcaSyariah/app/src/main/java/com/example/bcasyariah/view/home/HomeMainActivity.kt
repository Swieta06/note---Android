package com.example.bcasyariah.view.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.bcasyariah.R
import com.example.bcasyariah.databinding.ActivityHomeBinding
import com.example.bcasyariah.model.CategoryModel
import com.example.bcasyariah.model.NewsModel
import com.example.bcasyariah.view.detil.DetilNewsActivity

class HomeMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.componenAppBar.tvAppbar.text="Recycle New Activity"
//        binding.componenAppBar.ivBack.visibility=View.GONE
        binding.componenAppBar.ivBack.setOnClickListener{
            this.onBackPressed()
        }
        val mainAdapter = HomeMainAdapter(
            dataNews = populateData(),
            onClickNews = {
                DetilNewsActivity.navigateToActivityDetil(this, it)
            })
        binding.rvNews.adapter = mainAdapter
        val categoryAdapter = CategoryMainAdapter(
            data = populateDataCategory()
        )
        binding.rvListHorizontal.adapter = categoryAdapter
    }
    private fun populateData(): List<NewsModel> {
        val listData = listOf(
            NewsModel(
                image = R.drawable.bca,
                title = "Pakai BCA, Ada Diskon 66 Persen di Shopee dan Tokopedia",
                subtitle = "Bagi Anda yang ingin belanja melalui Shopee dan Tokopedia maka bis mendapatkan promo dan diskon."

            ),
            NewsModel(
                image = R.drawable.bca2,
                title = "Daftar Promo HUT BCA ke-66: Sushi Tei-Chatime Rp6 Ribu, Starbucks-Subway Diskon 66%",
                subtitle = "Berikut daftar promo HUT BCA ke-66 yang diberikan untuk pembelian makanan, minuman, hingga transaksi e-commerce."
            ),
            NewsModel(
                image = R.drawable.plane,
                title = "Gebyar HUT ke-66 BCA, Begini Cara Dapat Tiket Pesawat Murah",
                subtitle = "Sriwijaya Air memberi diskon besar-besaran pada momen HUT ke-66 BCA. Segini harga tiketnya."
            ),

            )
        return listData

    }

    private fun populateDataCategory(): List<CategoryModel> {
        val listData = listOf(
            CategoryModel(
                title = "sport"
            ),
            CategoryModel(
                title = "sport"
            ),
            CategoryModel(
                title = "sport"
            ),
            CategoryModel(
                title = "sport"
            ),
            CategoryModel(
                title = "sport"
            ),
            CategoryModel(
                title = "sport"
            ),
            CategoryModel(
                title = "sport"
            ),

            )
        return listData
    }


}