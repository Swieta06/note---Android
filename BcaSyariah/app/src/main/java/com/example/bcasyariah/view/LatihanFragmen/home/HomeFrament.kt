package com.example.bcasyariah.view.LatihanFragmen.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.bcasyariah.R
import com.example.bcasyariah.databinding.HomeFragmentBinding
import com.example.bcasyariah.view.LatihanFragmen.InputBiodata.InputBiodataFragment
import com.example.bcasyariah.view.LatihanFragmen.foodmenu.FoodMenuFragment

class HomeFrament:Fragment() {
    private lateinit var binding:HomeFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=HomeFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnRegister.setOnClickListener {
            initBiodataFragment()

        }
        binding.btnLogin.setOnClickListener {
            navigateToFoodMenu()
        }
        setAppBar()
    }
    private fun setAppBar(){
        /**
         * halaman home tidak butuh back
         * */
        binding.componenAppBar.ivBack.isVisible=false
    }
    private fun initBiodataFragment() {
        val registerFragment = InputBiodataFragment()
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, registerFragment)
            .addToBackStack(REGISTER_FRAGMENT_KEY)
            .commit()
    }

    private fun navigateToFoodMenu() {
        val menuFragment = FoodMenuFragment()
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, menuFragment)
            .addToBackStack(FOOD_FRAGMENT_KEY)
            .commit()
    }
    companion object{
        const val REGISTER_FRAGMENT_KEY="register"
        const val FOOD_FRAGMENT_KEY="food"

    }
}