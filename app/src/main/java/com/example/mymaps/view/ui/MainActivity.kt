package com.example.mymaps.view.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.mymaps.R
import com.example.mymaps.databinding.ActivityMainBinding
import com.example.mymaps.view.adapter.ProductsAdapter
import com.example.mymaps.view.viewModel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<ProductViewModel>()
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: ProductsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        adapter = ProductsAdapter()
        viewModel.getAllProducts()
        binding.rvProducts.adapter = adapter
        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.productList.collect {
                binding.isLoading = it.isLoading
                adapter.submitList(it.productList)
            }
        }
    }
}