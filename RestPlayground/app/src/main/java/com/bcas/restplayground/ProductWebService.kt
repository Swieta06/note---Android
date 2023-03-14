package com.bcas.restplayground

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductWebService {
    //https://fakestoreapi.com/products/1
    @GET("/products/1")
    fun getProduct(): Call<ProductResponse>

    @GET("/products")
    fun getProducts(): Call<List<ProductResponse>>

    @GET("/products/{id}")
    fun getSingleProduct(@Path(value = "id") id: Int): Call<ProductResponse>

    companion object {
        fun bulider(): ProductWebService {
            val gsonConverter = GsonConverterFactory.create()
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl("https://fakestoreapi.com")
                .addConverterFactory(gsonConverter)
                .client(okHttpClient)
                .build()
            val productWebService = retrofit.create(ProductWebService::class.java)
            return productWebService
        }
    }
}