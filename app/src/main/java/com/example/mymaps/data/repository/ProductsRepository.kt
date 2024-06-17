package com.example.mymaps.data.repository

import com.example.mymaps.common.utils.Resource
import com.example.mymaps.data.api.IProductsApi
import com.example.mymaps.data.db.ProductDb
import com.example.mymaps.data.model.ProductsResponseItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductsRepository @Inject constructor(
    private val productApi: IProductsApi,
    private val productDb: ProductDb
) :
    IProductsRepository {
    override fun fetchAllProducts(): Flow<Resource<List<ProductsResponseItem>>> = flow {
        emit(Resource.Loading())
        val response = productApi.fetchAllProducts()
        productDb.getProductDAO().addProducts(response)
        emit(Resource.Success(response))
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }
}