package com.example.shoppage.data

import androidx.compose.ui.graphics.ImageBitmap

data class Product(
    val productId: Long,
    val productName: String,
    val productImage: ImageBitmap,
    val description: String,
    val suitableSkinType: List<String>,
    val inStock: Boolean,
    val price: Int,
    val rating: Int,
    val reviews: Int
)
