package com.girrafeecstud.vk_services_list.ui.extension

import android.widget.ImageView
import com.girrafeecstud.vk_services_list.R
import com.squareup.picasso.Picasso

internal fun ImageView.loadAndSetImage(url: String) {
    Picasso.get()
        .load(url)
        .placeholder(R.drawable.blue_rectangle)
        .into(this)
}