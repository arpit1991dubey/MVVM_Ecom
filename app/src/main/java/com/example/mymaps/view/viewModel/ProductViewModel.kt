package com.example.mymaps.view.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymaps.common.utils.Resource
import com.example.mymaps.data.repository.ProductsRepository
import com.example.mymaps.view.viewModel.state.ProductListingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val repository: ProductsRepository) :
    ViewModel() {

    private val _productList = MutableStateFlow(ProductListingState())
    val productList: StateFlow<ProductListingState>
        get() = _productList

    fun getAllProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            val res = repository.fetchAllProducts()
            res.collect {
                when (it) {
                    is Resource.Success -> {
                        _productList.value =
                            ProductListingState().copy(productList = it.data, isLoading = false)
                        Log.d("listProductsViewModel", "onCreate: ${it.data}")

                    }

                    is Resource.Error -> _productList.value =
                        ProductListingState().copy(error = it.msg)

                    is Resource.Loading -> _productList.value =
                        ProductListingState().copy(isLoading = true)
                }
            }
        }
    }
}