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
        DiscountSwiper(discountList = List(3) { Discount() })
        CategoryList(
            categoryList = List(10) { Category() },
            onCategoryClick = {}
        )
        ProductsList(productList = List(5) { Product() }, modifier = Modifier.height(1500.dp))
    }
}

@VerticalScreenPreview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
