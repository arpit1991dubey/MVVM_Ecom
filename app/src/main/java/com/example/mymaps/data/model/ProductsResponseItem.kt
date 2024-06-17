package com.example.mymaps.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ProductTable")
data class ProductsResponseItem(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val category: String,
    val description: String,
    val image: String,
    val price: Double,
    val title: String
)
