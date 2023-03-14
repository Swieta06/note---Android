package com.example.bcasyariah.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bcasyariah.databinding.ItemCategoryBinding
import com.example.bcasyariah.model.CategoryModel


class CategoryMainAdapter(
private val data:List<CategoryModel>
):RecyclerView.Adapter<CategoryMainAdapter.CategoryViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder=
   CategoryViewHolder(
        ItemCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: CategoryMainAdapter.CategoryViewHolder, position: Int) {
        holder.bindingData(data[position])
    }

    override fun getItemCount(): Int = data.size
    inner class CategoryViewHolder(val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindingData(data: CategoryModel) {
            binding.tvProfile.text = data.title

        }
    }
}