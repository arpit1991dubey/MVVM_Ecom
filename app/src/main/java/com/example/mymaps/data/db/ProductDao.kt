package com.example.mymaps.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mymaps.data.model.ProductsResponseItem

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products : List<ProductsResponseItem>)

    @Query("SELECT * FROM ProductTable")
    suspend fun getProducts() : List<ProductsResponseItem>
}