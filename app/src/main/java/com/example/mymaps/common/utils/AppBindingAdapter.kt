package com.example.mymaps.common.utils

import android.view.View
import androidx.databinding.BindingAdapter

object AppBindingAdapter {

    @JvmStatic
    @BindingAdapter("app:visibility")
    fun visibility(view: View, isVisible: Boolean) {
        view.visibility = if (isVisible) View.VISIBLE else View.GONE
    }
}