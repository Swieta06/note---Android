package com.example.bcasyariah.view.home

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.bcasyariah.R
import com.example.bcasyariah.databinding.FoodCategoryBinding
import com.example.bcasyariah.databinding.ItemCategoryBinding
import com.example.bcasyariah.databinding.ItemFoodBinding
import com.example.bcasyariah.model.CategoryFoodModel

class CategoryFoodAdapter  (): RecyclerView.Adapter<CategoryFoodAdapter.CategoryFoodViewHolder>(){
    private var data:MutableList<CategoryFoodModel> = mutableListOf()
    private var onClickList:(CategoryFoodModel) -> Unit={}
    fun setData(newData:MutableList<CategoryFoodModel>){
        data = newData
        notifyDataSetChanged()

    }
    fun addOnClickFoodCategory(clickFood:(CategoryFoodModel)->Unit){
        onClickList=clickFood
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryFoodViewHolder=
        CategoryFoodViewHolder(
            FoodCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CategoryFoodViewHolder, position: Int) {
        holder.bindingData(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class CategoryFoodViewHolder(val binding: FoodCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindingData(data: CategoryFoodModel) {
            binding.tvCategory.text = data.title
            binding.constraintFood.setOnClickListener{
                onClickList(data)
            }
            val (selectedBackgroundRes,selectedColor)=if (data.isSelected?:false){
                Pair(R.drawable.background_rounded_selected,Color.CYAN)
            }else{
                Pair(R.drawable.background_rounded_outline_black,Color.BLACK)
            }
            val selectedBackground=ContextCompat.getDrawable(binding.root.context,selectedBackgroundRes)
            binding.constraintFood.background=selectedBackground
            binding.tvCategory.setTextColor(ColorStateList.valueOf(selectedColor))

        }
    }
}