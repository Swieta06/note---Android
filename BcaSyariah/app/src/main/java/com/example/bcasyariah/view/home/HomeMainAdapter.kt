package com.example.bcasyariah.view.home
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bcasyariah.databinding.ItemNewsBinding
import com.example.bcasyariah.model.NewsModel

class HomeMainAdapter(
    private val dataNews:List<NewsModel>,
    private val onClickNews:(NewsModel)->Unit,
) :
    RecyclerView.Adapter<HomeMainAdapter.HomeMainViewOlder>() {
    inner class HomeMainViewOlder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bindView(data: NewsModel, onClickNews: (NewsModel) -> Unit) {
            binding.ivItemNews.setImageResource(data.image?:0)
            binding.tvTitleCard.text=data.title
            binding.tvDescCard.text=data.subtitle
            binding.llNews.setOnClickListener{
                onClickNews(data)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeMainViewOlder =
        HomeMainViewOlder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount():Int=dataNews.size

    override fun onBindViewHolder(holder: HomeMainViewOlder, position: Int) {
        holder.bindView(dataNews[position],onClickNews)
    }


}