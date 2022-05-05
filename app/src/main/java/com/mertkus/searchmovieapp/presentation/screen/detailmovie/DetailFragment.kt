package com.mertkus.searchmovieapp.presentation.screen.detailmovie

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.mertkus.searchmovieapp.core.base.BaseFragment
import com.mertkus.searchmovieapp.core.util.collectLatestLifecycleFlow
import com.mertkus.searchmovieapp.databinding.FragmentDetailBinding
import com.mertkus.searchmovieapp.domain.model.Movie
import dagger.hilt.android.AndroidEntryPoint

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Mert KUŞ      │
//│ ──────────────────────── │
//│ mertkusdev@gmail.com     │
//│ ──────────────────────── │
//│ 24.04.2022               │
//└──────────────────────────┘

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(
    FragmentDetailBinding::inflate
) {
    private val safeArgs: DetailFragmentArgs by navArgs()
    private val viewModel: DetailViewModel by viewModels()

    private lateinit var imdbId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imdbId = safeArgs.imdbID
    }

    override fun onCreateViewInvoke() {
        collectLatestLifecycleFlow(viewModel.state, ::handleViewState)
        viewModel.onMovie(imdbId)
    }

    private fun handleViewState(uiState: DetailUiState) {
        setProgressStatus(uiState.isLoading)
        uiState.movieItems?.let {
            bindMovie(uiState.movieItems)
        }
    }

    private fun bindMovie(movie: Movie) {
        fragmentBinding.selectedMovie = movie
    }


}
