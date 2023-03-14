package com.example.bcasyariah.view.LatihanFragmen.InputBiodata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bcasyariah.R
import com.example.bcasyariah.databinding.InputBiodataFragmentBinding

class InputBiodataFragment : Fragment() {
    private lateinit var binding: InputBiodataFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = InputBiodataFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSubmit.setOnClickListener {
            handleSubmitButton()
        }

        setAppbar()
    }

    private fun setAppbar() {
        binding.includeLayout.tvAppbar.text = "input biodata"
        binding.includeLayout.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun handleSubmitButton() {
        val checkEtName = binding.etName.text.isNullOrEmpty().not()
        val checkEtAlamat = binding.etAlamat.text.isNullOrEmpty().not()
        val checkEtPhone = binding.etPhone.text.isNullOrEmpty().not()
        val checkEtEmail = binding.etEmail.text.isNullOrEmpty().not()
        if (checkEtName && checkEtAlamat && checkEtPhone && checkEtEmail) {
            /**
             * bundle buat ambil data yang mau dikembalikan
             * */
            var bundle = Bundle().apply {
                putString(NAME_KEY, binding.etName.text.toString())

            }
            val successFragment = SuccesBiodataFragment().apply {
                arguments = bundle
            }
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, successFragment)
                .commit()
        } else {
            Toast.makeText(context, "Tolong lengkapi biodata", Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        const val NAME_KEY = "name"
    }
}