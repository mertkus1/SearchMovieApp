package com.mertkus.searchmovieapp.presentation.screen.searchinfo

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.mertkus.searchmovieapp.R
import com.mertkus.searchmovieapp.core.base.BaseFragment
import com.mertkus.searchmovieapp.core.util.*
import com.mertkus.searchmovieapp.databinding.FragmentSearchinfoBinding
import com.mertkus.searchmovieapp.domain.model.Search
import com.mertkus.searchmovieapp.domain.model.SearchInfo
import com.mertkus.searchmovieapp.presentation.adapter.SearchInfoAdapter
import dagger.hilt.android.AndroidEntryPoint

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Mert KUŞ      │
//│ ──────────────────────── │
//│ mertkusdev@gmail.com     │
//│ ──────────────────────── │
//│ 20.04.2022               │
//└──────────────────────────┘

@AndroidEntryPoint
class SearchInfoFragment : BaseFragment<FragmentSearchinfoBinding>(
    FragmentSearchinfoBinding::inflate
), SearchView.OnQueryTextListener {
    private val navController by lazy {
        activity?.let {
            Navigation.findNavController(it, R.id.nav_host_fragmentContainerView)
        }
    }

    private val rotateOpen: Animation by lazy {
        AnimationUtils.loadAnimation(
            requireContext(),
            R.anim.translate_search_anim
        )
    }

    private val open: Animation by lazy {
        AnimationUtils.loadAnimation(
            requireContext(),
            R.anim.infinity
        )
    }

    private val viewModel: SearchInfoViewModel by viewModels()

    private var isFirst = true
    private var searchAdapter: SearchInfoAdapter? = null
    private lateinit var data: SearchInfo

    override val progressBar: View
        get() = fragmentBinding.pbMovieLoading

    override fun onCreateViewInvoke() {
        val searchView = fragmentBinding.searchView
        searchView.setOnQueryTextListener(this)
        collectLatestLifecycleFlow(viewModel.state, ::handleViewState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(fragmentBinding) {
            ivSearch.onClickListener(::ivSearchClickListener)
            ivSearchAnim.onClickListener(::ivSearchAnimClickListener)
        }
        isFirstTimeRun(isFirst)
    }

    private fun handleViewState(uiState: SearchInfoState) {
        setProgressStatus(uiState.isLoading)
        uiState.searchInfoItems?.let {
            handleSearchInfo(uiState.searchInfoItems)
        }
    }

    private fun handleSearchInfo(searchInfo: SearchInfo) {
        data = searchInfo
        searchInfo.search?.let { initRecyclerViewItem(it) }
    }

    private fun handleSearch(query: String?) {
        if (query != null && query.isNotEmpty()) {
            viewModel.onSearch(query)
            hideKeyboard(requireActivity())
        }
    }

    private fun navigateToDetail(selectedMovie: String) {
        val action = SearchInfoFragmentDirections.actionSearchInfoFragmentToDetailFragment(
            selectedMovie
        )
        navController?.navigate(action)
    }

    private fun initRecyclerViewItem(movieList: List<Search>) {
        with(fragmentBinding.rvMovieList) {
            if (searchAdapter == null || adapter == null) {
                searchAdapter = SearchInfoAdapter(::navigateToDetail)
                layoutManager = LinearLayoutManager(requireContext())
                adapter = searchAdapter
                setHasFixedSize(true)
                setDivider(R.drawable.divider)
            }
        }
        searchAdapter!!.differ.submitList(movieList)
    }

    private fun ivSearchAnimClickListener() = with(fragmentBinding) {
        ivSearchAnim.isClickable = false
        ivSearchAnim.visibility = View.GONE
        ivSearchAnim.startAnimation(rotateOpen)
        ivSearch.increaseVisibility(View.VISIBLE, 800)
        searchView.visibility = View.VISIBLE
        searchView.requestFocus()
        ivSearch.startAnimation(open)
        tvMovieSearch.visibility = View.GONE
        showKeyboard(requireActivity())
    }

    private fun ivSearchClickListener() {
        handleSearch(fragmentBinding.searchView.query.toString())
    }

    private fun isFirstTimeRun(isFirstRun: Boolean) = with(fragmentBinding) {
        if (isFirstRun) {
            ivSearchAnim.startAnimation(open)
            isFirst = !isFirstRun
        } else {
            ivSearchAnim.visibility = View.GONE
            searchView.visibility = View.VISIBLE
            tvMovieSearch.visibility = View.GONE
            searchView.requestFocus()
            ivSearch.startAnimation(open)
            initRecyclerViewItem(data.search!!)
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        handleSearch(query)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}