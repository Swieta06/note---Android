package com.example.bcasyariah.view.LatihanFragmen.foodmenu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bcasyariah.databinding.ItemFoodBinding
import com.example.bcasyariah.model.FoodModel

class FoodAdapter (
//    private val dataNews:List<FoodModel>,
//    private val onClickNews:(FoodModel)->Unit,
) :
    RecyclerView.Adapter<FoodAdapter.HomeMainViewOlder>() {

    private var dataFood:MutableList<FoodModel> = mutableListOf()
    fun setData(newData:MutableList<FoodModel>){
        dataFood=newData
        notifyDataSetChanged()

    }
    inner class HomeMainViewOlder(val binding: ItemFoodBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bindView(data: FoodModel) {
           Glide.with(binding.root.context)
               .load(data.image)
               .into(binding.ivItemFood)

            binding.tvTitleCard.text=data.title
            binding.tvDescCard.text=data.subtitle
            binding.llFood.setOnClickListener{

            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeMainViewOlder =
        HomeMainViewOlder(
            ItemFoodBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount():Int=dataFood.size

    override fun onBindViewHolder(holder: HomeMainViewOlder, position: Int) {
        holder.bindView(dataFood[position])
    }


}