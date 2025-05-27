package com.example.shoppage.data

import com.example.shoppage.R

data class Product(
    val productId: Long = 1,
    val productName: String = "Some Product",
    val productImage: Int = R.drawable.product_image,
    val description: String = "Very useful",
    val suitableSkinType: List<String> = listOf("Oily Skin", "Dry & Dehyrated Skin"),
    val inStock: Boolean = true,
    val isBestSeller: Boolean = true,
    val isFavourite: Boolean = false,
    val actualPrice: Float = 444f,
    val discountedPrice: Float = 355.20f,
    val rating: Int = 4,
    val reviews: Int = 245
)