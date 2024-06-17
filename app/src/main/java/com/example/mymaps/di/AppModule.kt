package com.example.mymaps.di

import android.content.Context
import androidx.room.Room
import com.example.mymaps.common.constants.AppConstants.BASE_URL
import com.example.mymaps.data.api.IProductsApi
import com.example.mymaps.data.db.ProductDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApiInstance(retrofit: Retrofit): IProductsApi =
        retrofit.create(IProductsApi::class.java)

    @Provides
    @Singleton
    fun provideProductDB(@ApplicationContext context: Context): ProductDb {
        return Room.databaseBuilder(context, ProductDb::class.java, "ProductDB").build()
    }

}