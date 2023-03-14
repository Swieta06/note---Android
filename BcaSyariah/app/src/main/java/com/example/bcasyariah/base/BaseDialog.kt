package com.example.bcasyariah.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.bcasyariah.R
import com.example.bcasyariah.databinding.ActivityBaseDialogBinding

class BaseDialog(context: Context,
                 var title: String,
                 var subtitle: String,
                 private val onClicked:(()->Unit),
                 private val withImage:Boolean,
                 private val image:Int?=null
                 ) : Dialog(context) {
    private lateinit var binding: ActivityBaseDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivDialog.setImageResource(image?: R.drawable.ic_baseline_supervised_user_circle_24)
        binding.ivDialog.isVisible=withImage
        binding.tvDialogSubtitle.text = title
        binding.tvDialogTitle.text = subtitle
        binding.btnCancle.setOnClickListener { dismissdialog() }
        binding.btnProceed.setOnClickListener {
            onClicked.invoke()
        }
    }
    private fun dismissdialog() {
        dismiss()
    }

}