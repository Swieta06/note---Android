package com.example.bcasyariah.view.setting

import android.content.ClipData.Item
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.bcasyariah.databinding.ActivityListBinding
import com.example.bcasyariah.databinding.ItemSimpleBinding

class SettingAdapter : RecyclerView.Adapter<SettingAdapter.SettingViewHolder>() {
    inner class SettingViewHolder(
        private val binding: ItemSimpleBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String) {
            binding.itemTvUser.text = item
        }
    }

    private val items: MutableList<String> = mutableListOf()
    fun addItems(newsItem: List<String>) {
        items.addAll(newsItem)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemSimpleBinding.inflate(layoutInflater, parent, false)
        return SettingViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: SettingViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}