package com.bcas.restplayground

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bcas.restplayground.databinding.ActivityProductsBinding
import com.bcas.restplayground.databinding.ItemProductBinding
import com.bumptech.glide.Glide

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductsViewHolder>() {
//pertama bikin adapter untuk onclick
    private var dataProducts:MutableList<ProductResponse> = mutableListOf()
    private var onClick:(ProductResponse)->Unit={}



    inner class ProductsViewHolder(
        private val binding: ItemProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ProductResponse,onClick:(ProductResponse)->Unit) {
            binding.tvProductName.text = item.title
            binding.tvProductPrice.text = "Rp${item.price}"
            Glide.with(binding.root.context)
                .load(item.image)
                .circleCrop()
                .into(binding.imgProduct)

            binding.clProduct.setOnClickListener {
                onClick(item)
            }

        }

    }
    //ini buta apa?
    fun addNewProducts(newProducts: List<ProductResponse>){
        dataProducts.addAll(newProducts)
        notifyDataSetChanged()
    }
    fun onClickProduct(clickProduct: (ProductResponse)->Unit){
        onClick = clickProduct
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(inflater, parent, false)
        val viewHolder = ProductsViewHolder(binding)
        return viewHolder
    }

    override fun getItemCount(): Int {
       return dataProducts.size
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(dataProducts[position],onClick)
    }


}