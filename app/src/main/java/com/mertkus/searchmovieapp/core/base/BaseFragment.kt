package com.mertkus.searchmovieapp.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<DB : ViewDataBinding>(
    private val inflateLayout: (LayoutInflater, ViewGroup?, Boolean) -> DB,
) : Fragment() {
    private var _fragmentBinding: DB? = null
    protected val fragmentBinding get() = _fragmentBinding!!

    protected open val progressBar: View? = null

    protected fun setProgressStatus(isLoading: Boolean) {
        progressBar?.isVisible = isLoading
    }

    open fun onCreateViewInvoke() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _fragmentBinding = inflateLayout(layoutInflater, container, false)
        onCreateViewInvoke()
        return fragmentBinding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentBinding = null
    }
}
