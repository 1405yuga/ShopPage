package com.example.shoppage.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.shoppage.R
import com.example.shoppage.data.Product
import com.example.shoppage.ui.theme.CenturyOldStyleTextStyle
import com.example.shoppage.ui.theme.Neon
import com.example.shoppage.ui.theme.Purple80
import com.example.shoppage.utils.annotations.HorizontalScreenPreview
import com.example.shoppage.utils.annotations.VerticalScreenPreview

@Composable
fun ProductsList(productList: List<Product>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(modifier = modifier.padding(bottom = 10.dp)) {
            Text(
                text = "New Products",
                style = CenturyOldStyleTextStyle,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "See all",
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {

                })
        }
        LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            items(productList) { product ->
                ProductItem(
                    product,
                    onProductClick = {},
                    onFavouriteClick = {},
                )
            }
        }
    }
}

@Composable
@VerticalScreenPreview
fun ProductListVertical() {
    ProductsList(productList = List(5) { Product() })
}

@Composable
@HorizontalScreenPreview
fun ProductListHorizontal() {
    ProductsList(productList = List(5) { Product() })
}

@Composable
fun ProductItem(product: Product, onProductClick: () -> Unit, onFavouriteClick: () -> Unit) {
    Box {
        Image(
            painter = painterResource(R.drawable.product_bg_card),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Column(modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                    onClick = { onFavouriteClick() },
                    modifier = Modifier
                        .clip(RoundedCornerShape(40.dp))
                        .background(Color.Black)
                ) {
                    Icon(
                        if (product.isFavourite) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder,
                        contentDescription = "Add to favourite",
                        tint = Purple80,
                        modifier = Modifier.size(30.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                if (product.isBestSeller) {
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.Black),
                        modifier = Modifier.padding(horizontal = 8.dp)
                    ) {
                        Text(
                            text = "Best seller",
                            fontWeight = FontWeight.ExtraBold,
                            color = Neon,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                        )
                    }
                }
            }
            Image(
                painter = painterResource(product.productImage),
                contentDescription = "Product image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(300.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
@VerticalScreenPreview
fun ProductItemVerticalPreview() {
    ProductItem(product = Product(), onProductClick = {}, onFavouriteClick = {})
}