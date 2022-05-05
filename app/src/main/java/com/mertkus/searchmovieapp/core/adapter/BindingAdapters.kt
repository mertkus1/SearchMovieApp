package com.mertkus.searchmovieapp.core.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.mertkus.searchmovieapp.core.util.downloadFromUrl
import com.mertkus.searchmovieapp.core.util.placeholderProgressBar

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Mert KUŞ      │
//│ ──────────────────────── │
//│ mertkusdev@gmail.com     │
//│ ──────────────────────── │
//│ 20.04.2022               │
//└──────────────────────────┘


@BindingAdapter("loadImage")
fun loadImage(view: ImageView, imageUri: String?) {
    view.downloadFromUrl(imageUri, placeholderProgressBar(view.context))
}

