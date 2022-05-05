package com.mertkus.searchmovieapp.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mertkus.searchmovieapp.domain.model.Search
import com.mertkus.searchmovieapp.presentation.adapter.viewholder.SearchInfoViewHolder

class SearchInfoAdapter(
    private val onClickMovie: (String) -> Unit
) :
    RecyclerView.Adapter<SearchInfoViewHolder>() {
    val differ = AsyncListDiffer(this, DIFF_CALLBACK)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchInfoViewHolder {
        return SearchInfoViewHolder.create(parent, onClickMovie)
    }

    override fun onBindViewHolder(holder: SearchInfoViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount() = differ.currentList.size


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Search>() {
            override fun areItemsTheSame(oldItem: Search, newItem: Search) = oldItem == newItem
            override fun areContentsTheSame(oldItem: Search, newItem: Search) =
                oldItem == newItem
        }
    }


}