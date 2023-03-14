package com.bcas.zwallet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bcas.zwallet.databinding.ActivityItemMainBinding

class TransactionAdapter:RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {
    inner class TransactionViewHolder(
        private val binding:ActivityItemMainBinding

    ):RecyclerView.ViewHolder(binding.root){
        fun bind(transaction: Transaction){
            binding.itemCardContent.setImageUrl(transaction.imageUrl)
            binding.itemCardContent.setTitle(transaction.name)
            binding.itemCardContent.setSubTitle(transaction.status)
            binding.itemCardContent.setSPrivate(transaction.amount)
        }
    }
    private val items:MutableList<Transaction> = mutableListOf()
    fun addNewItem(newItems:List<Transaction>) {
        items.addAll(newItems)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
       val view=LayoutInflater.from(parent.context)
        val binding=ActivityItemMainBinding.inflate(view,parent,false)
        return TransactionViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
       val item=items[position]
        holder.bind(item)
    }


}