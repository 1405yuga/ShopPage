package com.example.shoppage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shoppage.data.Category
import com.example.shoppage.data.Discount
import com.example.shoppage.data.Product
import com.example.shoppage.ui.screens.CategoryList
import com.example.shoppage.ui.screens.DiscountSwiper
import com.example.shoppage.ui.screens.ProductsList
import com.example.shoppage.ui.theme.CenturyOldStyleTextStyle
import com.example.shoppage.ui.theme.ShopPageTheme
import com.example.shoppage.utils.annotations.HorizontalScreenPreview
import com.example.shoppage.utils.annotations.VerticalScreenPreview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShopPageTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TitleBar(
                            onBackClick = {},
                            onSearchClick = {},
                            onFavouritesClick = {},
                            onAddToCartClick = {}
                        )
                    }) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleBar(
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    onFavouritesClick: () -> Unit,
    onAddToCartClick: () -> Unit
) {
    TopAppBar(
        title = { Text(text = "Shop", style = CenturyOldStyleTextStyle) },
        navigationIcon = {
            IconButton(onClick = { onBackClick() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back Button")
            }
        },
        actions = {
            IconButton(onClick = { onSearchClick() }) {
                Icon(Icons.Outlined.Search, contentDescription = "Search Button")
            }
            IconButton(onClick = { onFavouritesClick() }) {
                Icon(Icons.Outlined.FavoriteBorder, contentDescription = "Favourite Button")
            }
            IconButton(onClick = { onAddToCartClick() }) {
                Icon(Icons.Outlined.ShoppingCart, contentDescription = "Shopping Cart Button")
            }

        }
    )
}

@Composable
@VerticalScreenPreview
fun TitleBarVerticalPreview() {
    TitleBar(
        onBackClick = {},
        onSearchClick = {},
        onFavouritesClick = {}
    ) { }
}

@Composable
@HorizontalScreenPreview
fun TitleBarHorizontalPreview() {
    TitleBar(
        onBackClick = {},
        onSearchClick = {},
        onFavouritesClick = {}
    ) { }
}


@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(horizontal = 12.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        DiscountSwiper(
            discountList = listOf(
                Discount(),
                Discount(
                    title = "Flat ₹100 Off",
                    subTitle = "Save ₹100 on orders above ₹499",
                    dateString = "1st June - 5th June"
                ),
                Discount(
                    title = "Buy 1 Get 1 Free",
                    subTitle = "On all accessories and essentials",
                    dateString = "10th June - 14th June"
                )
            )
        )
        CategoryList(
            categoryList = listOf(
                Category(
                    categoryId = 1,
                    categoryName = "Moisturizer",
                    categoryImage = R.drawable.categorysample
                ),
                Category(
                    categoryId = 2,
                    categoryName = "Serum",
                    categoryImage = R.drawable.categorysample
                ),
                Category(
                    categoryId = 3,
                    categoryName = "Cleanser",
                    categoryImage = R.drawable.categorysample
                ),
                Category(
                    categoryId = 4,
                    categoryName = "Sunscreen",
                    categoryImage = R.drawable.categorysample
                ),
                Category(
                    categoryId = 5,
                    categoryName = "Lip Care",
                    categoryImage = R.drawable.categorysample
                ),
                Category(
                    categoryId = 6,
                    categoryName = "Face Mask",
                    categoryImage = R.drawable.categorysample
                ),
                Category(
                    categoryId = 7,
                    categoryName = "Hair Care",
                    categoryImage = R.drawable.categorysample
                ),
                Category(
                    categoryId = 8,
                    categoryName = "Eye Cream",
                    categoryImage = R.drawable.categorysample
                ),
                Category(
                    categoryId = 9,
                    categoryName = "Exfoliator",
                    categoryImage = R.drawable.categorysample
                ),
                Category(
                    categoryId = 10,
                    categoryName = "Body Lotion",
                    categoryImage = R.drawable.categorysample
                )
            ),
            onCategoryClick = {}
        )
        ProductsList(
            productList = listOf(
                Product(
                    productId = 1,
                    productName = "Hydrating Face Serum",
                    productImage = R.drawable.product_image,
                    description = "Rejuvenates and hydrates the skin deeply.",
                    suitableSkinType = listOf("Dry Skin", "Normal Skin"),
                    inStock = true,
                    isBestSeller = true,
                    isFavourite = true,
                    actualPrice = 899f,
                    discountedPrice = 699f,
                    rating = 5,
                    reviews = 320
                ),
                Product(
                    productId = 2,
                    productName = "SPF 50+ Sunscreen",
                    productImage = R.drawable.product_image,
                    description = "Provides strong protection from UV rays.",
                    suitableSkinType = listOf("Oily Skin", "Combination Skin"),
                    inStock = true,
                    isBestSeller = false,
                    isFavourite = false,
                    actualPrice = 749f,
                    discountedPrice = 599f,
                    rating = 4,
                    reviews = 180
                ),
                Product(
                    productId = 3,
                    productName = "Aloe Vera Moisturizer",
                    productImage = R.drawable.product_image,
                    description = "Soothes and moisturizes sensitive skin.",
                    suitableSkinType = listOf("Sensitive Skin", "Dry Skin"),
                    inStock = false,
                    isBestSeller = false,
                    isFavourite = false,
                    actualPrice = 499f,
                    discountedPrice = 399f,
                    rating = 3,
                    reviews = 75
                ),
                Product(
                    productId = 4,
                    productName = "Charcoal Face Wash",
                    productImage = R.drawable.product_image,
                    description = "Deep cleanses pores and removes impurities.",
                    suitableSkinType = listOf("Oily Skin", "Acne-Prone Skin"),
                    inStock = true,
                    isBestSeller = true,
                    isFavourite = true,
                    actualPrice = 349f,
                    discountedPrice = 299f,
                    rating = 4,
                    reviews = 220
                ),
                Product(
                    productId = 5,
                    productName = "Vitamin C Brightening Cream",
                    productImage = R.drawable.product_image,
                    description = "Enhances glow and brightens dull skin.",
                    suitableSkinType = listOf("All Skin Types"),
                    inStock = true,
                    isBestSeller = false,
                    isFavourite = false,
                    actualPrice = 999f,
                    discountedPrice = 799f,
                    rating = 5,
                    reviews = 410
                )
            ), modifier = Modifier.height(1500.dp)
        )
    }
}

@VerticalScreenPreview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
