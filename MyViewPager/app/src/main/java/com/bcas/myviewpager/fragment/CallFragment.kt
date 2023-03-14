package com.bcas.myviewpager.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bcas.myviewpager.databinding.FragmentCallBinding

class CallFragment:Fragment() {
    private var binding:FragmentCallBinding?=null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCallBinding.inflate(inflater,container,false)
        return binding?.root

    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
    }
}