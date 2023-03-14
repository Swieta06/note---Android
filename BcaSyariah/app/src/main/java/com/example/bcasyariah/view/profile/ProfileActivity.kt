package com.example.bcasyariah.view.profile

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bcasyariah.R
import com.example.bcasyariah.base.BaseDialog
import com.example.bcasyariah.databinding.ActivityProfileBinding
import com.example.bcasyariah.view.login.LoginActivity.Companion.KEY_ADDRESS
import com.example.bcasyariah.view.login.LoginActivity.Companion.KEY_INPUT
import com.example.bcasyariah.view.login.LoginActivity.Companion.KEY_NAME

class ProfileActivity:AppCompatActivity() {
    private lateinit var binding:ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name=intent.getStringExtra(KEY_NAME)
        val address=intent.getStringExtra(KEY_ADDRESS)
        val vaalueInput=intent.getStringExtra(KEY_INPUT)
        binding.tvName.text=vaalueInput
        binding.componenAppBar.tvAppbar.text="Profile"

        logout()

    }

    private fun logout(){
        binding.btnLogout.setOnClickListener {
            val dialog=BaseDialog(this,
                "Peringatan",
                "Ketika click button ok maka akan ter logout",
                onClicked = {
//                Toast.makeText(applicationContext,"ini button procced",Toast.LENGTH_LONG).show()
                finish()
            }, withImage = false,
            image = R.drawable.ic_launcher_background
            )
            dialog.setCancelable(false)
            dialog.show()
        }


    }
}