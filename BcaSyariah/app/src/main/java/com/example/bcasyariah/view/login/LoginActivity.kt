package com.example.bcasyariah.view.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bcasyariah.databinding.ActivityLoginBinding
import com.example.bcasyariah.view.biodata.BiodataActivity
import com.example.bcasyariah.view.profile.ProfileActivity

class LoginActivity:AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    val email ="swieta@gmail.com"
    private val name="swieta nh"
    private val address="jl blablablabla"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val email=binding.etEmail.text.toString()
            navigationScreenWithInput(ProfileActivity::class.java,email)
//            if(email=="swieta@gmail.com"){
//
//                Toast.makeText(applicationContext, "berhasil login", Toast.LENGTH_SHORT).show()
               // val intent = Intent(applicationContext, BiodataActivity::class.java)
//               navigationScreen(ProfileActivity::class.java)


//            }else{
//                Toast.makeText(applicationContext, "gagal login", Toast.LENGTH_SHORT).show()
//            }
showloading()
        }
        binding.pbLoading.setOnClickListener{
            hideloading()
        }

    }


    private fun showloading(){
        binding.pbLoading.visibility=View.VISIBLE
        binding.btnSubmit.visibility=View.GONE
    }
    private fun hideloading(){
        binding.pbLoading.visibility=View.GONE
        binding.btnSubmit.visibility=View.VISIBLE
    }
    private  fun navigationScreen(screen:Class<*>){
        val intent=Intent(applicationContext,screen)
        intent.putExtra(KEY_NAME,name)
        intent.putExtra(KEY_ADDRESS,address)
        startActivity(intent)



    }

    private fun navigationScreenWithInput(screen: Class<*>,input:String){
        val intent=Intent(applicationContext,screen)
        intent.putExtra(KEY_INPUT,input)
        startActivity(intent)

    }
////    untuk yang sifatanya statis
   companion object{
     const val  KEY_NAME="name"
     const val KEY_ADDRESS="address"
    const val KEY_INPUT="Input"

    }
}