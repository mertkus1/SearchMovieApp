package com.mertkus.searchmovieapp.presentation.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mertkus.searchmovieapp.databinding.ItemMovieBinding
import com.mertkus.searchmovieapp.domain.model.Search

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Mert KUŞ      │
//│ ──────────────────────── │
//│ mertkusdev@gmail.com     │
//│ ──────────────────────── │
//│ 25.04.2022               │
//└──────────────────────────┘

class SearchInfoViewHolder(
    private val binding: ItemMovieBinding,
    private val onClickMovie: (String) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(search: Search) {
        binding.movie = search
        binding.root.setOnClickListener { onClickMovie(search.imdbID) }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            onClickMovie: (String) -> Unit,
        ): SearchInfoViewHolder {
            val view = ItemMovieBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return SearchInfoViewHolder(view, onClickMovie)
        }
    }
}