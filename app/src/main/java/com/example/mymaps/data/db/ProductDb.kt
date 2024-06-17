package com.example.mymaps.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mymaps.data.model.ProductsResponseItem

@Database(entities = [ProductsResponseItem::class], version = 1)
abstract class ProductDb : RoomDatabase() {

    abstract fun getProductDAO(): ProductDao

}