package com.example.shoppage.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppage.R
import com.example.shoppage.data.Product
import com.example.shoppage.ui.theme.CenturyOldStyleTextStyle
import com.example.shoppage.ui.theme.Neon
import com.example.shoppage.ui.theme.Purple80
import com.example.shoppage.ui.theme.Red
import com.example.shoppage.ui.theme.TangerineTextStyle
import com.example.shoppage.utils.annotations.HorizontalScreenPreview
import com.example.shoppage.utils.annotations.VerticalScreenPreview
import com.example.shoppage.utils.composables.StarRating

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
        IconButton(
            onClick = { onFavouriteClick() },
            modifier = Modifier.background(color = Color.Black, shape = CircleShape)
        ) {
            Icon(
                if (product.isFavourite) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder,
                contentDescription = "Add to favourite",
                tint = Purple80,
                modifier = Modifier.size(30.dp)
            )
        }
        Column(modifier = Modifier.padding(vertical = 12.dp, horizontal = 8.dp)) {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Black),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .align(Alignment.End)
            ) {
                Text(
                    text = "Best seller",
                    fontWeight = FontWeight.ExtraBold,
                    color = Neon,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                )
            }
            Image(
                painter = painterResource(product.productImage),
                contentDescription = "Product image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(300.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Box {
                Image(
                    painter = painterResource(R.drawable.product_title_card),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxWidth()
                )
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    Row {
                        Text(text = product.productName, style = TangerineTextStyle)
                        Spacer(modifier = Modifier.weight(1f))
                        if (product.inStock) {
                            Text("• In stock", color = Neon)
                        } else {
                            Text("• Out of stock", color = Red)
                        }
                    }
                    Text(text = product.description, color = Color.White)
                    Text(
                        text = product.suitableSkinType.joinToString(" • "),
                        color = Color.White,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Row(
                        modifier = Modifier.padding(top = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "RS. ${String.format("%.2f", product.discountedPrice)}",
                            color = Purple80,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                        Text(
                            text = "RS. ${String.format("%.2f", product.actualPrice)}",
                            color = Purple80,
                            fontSize = 16.sp,
                            textDecoration = TextDecoration.LineThrough
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        StarRating(product.rating)
                        Text(
                            text = "${product.reviews} reviews",
                            textDecoration = TextDecoration.Underline,
                            color = Color.White,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                }
            }
        }

        IconButton(
            onClick = {},
            modifier = Modifier
                .padding(bottom = 26.dp, end = 20.dp)
                .align(Alignment.BottomEnd)
                .border(shape = CircleShape, color = Neon, width = 2.dp)
        ) {
            Icon(
                Icons.Filled.ShoppingCart,
                contentDescription = "Add to cart",
                tint = Neon
            )
        }
    }
}

@Composable
@VerticalScreenPreview
fun ProductItemVerticalPreview() {
    ProductItem(product = Product(), onProductClick = {}, onFavouriteClick = {})
}