package com.example.newsreader.presentation;

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.newsreader.data.dto.request.ArticleResponse
import com.example.newsreader.databinding.ListViewItemBinding


class NewsListAdapter : ListAdapter<ArticleResponse, NewsListAdapter.NewsResponseViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<ArticleResponse>() {
        override fun areItemsTheSame(oldItem: ArticleResponse, newItem: ArticleResponse): Boolean {
            return oldItem.source?.name == newItem.source?.name
        }

        override fun areContentsTheSame(oldItem: ArticleResponse, newItem: ArticleResponse): Boolean {
            return oldItem.content == newItem.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsResponseViewHolder {
        return NewsResponseViewHolder(ListViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: NewsResponseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class NewsResponseViewHolder(private val binding: ListViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(Articles: ArticleResponse) {
            binding.title.text = Articles.title
            binding.image.load(Articles.urlToImage?.toUri()?.buildUpon()?.scheme("https")?.build())
            binding.description.text = Articles.description
        }
    }
}