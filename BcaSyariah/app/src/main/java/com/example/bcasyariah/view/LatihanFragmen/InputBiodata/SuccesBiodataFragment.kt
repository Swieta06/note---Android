package com.example.bcasyariah.view.LatihanFragmen.InputBiodata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bcasyariah.databinding.SuccessRegisterFragmentBinding
import com.example.bcasyariah.view.LatihanFragmen.InputBiodata.InputBiodataFragment.Companion.NAME_KEY

class SuccesBiodataFragment:Fragment() {
    private lateinit var binding:SuccessRegisterFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=SuccessRegisterFragmentBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gaetDataArguments()
    }
    private fun gaetDataArguments(){
        val getNameFromAargument=arguments?.getString(NAME_KEY)
        binding.tvName.text=getNameFromAargument
    }
}