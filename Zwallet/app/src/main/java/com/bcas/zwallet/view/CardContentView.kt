package com.bcas.zwallet.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.bcas.zwallet.R
import com.bumptech.glide.Glide


class CardContentView(context: Context, attributeSet: AttributeSet) :
    FrameLayout(context, attributeSet) {
    private val ccImageView: AppCompatImageView by lazy {
        findViewById(R.id.cc_image)
    }
    private val ccTvTitle: TextView by lazy {
        findViewById(R.id.cc_tv_title)
    }
    private val ccTvSubTitle: TextView by lazy {
        findViewById(R.id.cc_tv_subtitle)
    }
    private val ccTvPrice: TextView by lazy {
        findViewById(R.id.cc_tv_price)
    }

    /**
     * init block: ini code yang dieksekusi ketika instance object dari kelas ini
     * terbuat
     * **/

    init {
        inflate(context, R.layout.layout_card_content_view, this)
    }

    fun setImageUrl(imageUrl:String){
        Glide.with(this).load(imageUrl).into(ccImageView)

    }
    fun setTitle(title:String){
        ccTvTitle.text=title

    }
    fun setSubTitle(subtitle:String){
       ccTvSubTitle.text=subtitle

    }
    fun setSPrivate(price:String){
        ccTvPrice.text=price

    }
}