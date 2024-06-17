package com.example.mymaps.data.repository

import com.example.mymaps.common.utils.Resource
import com.example.mymaps.data.model.ProductsResponseItem
import kotlinx.coroutines.flow.Flow

interface IProductsRepository {
    fun fetchAllProducts(): Flow<Resource<List<ProductsResponseItem>>>
}