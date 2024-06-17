package com.example.mymaps.data.api

import com.example.mymaps.data.model.ProductsResponseItem
import retrofit2.http.GET

interface IProductsApi {

    @GET("products")
    suspend fun fetchAllProducts(): List<ProductsResponseItem>

}