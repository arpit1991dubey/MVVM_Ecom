package com.example.mymaps.view.viewModel.state

import com.example.mymaps.data.model.ProductsResponseItem

data class ProductListingState(
    val productList: List<ProductsResponseItem>? = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
