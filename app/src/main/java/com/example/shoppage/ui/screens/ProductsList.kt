package com.example.shoppage.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import com.example.shoppage.data.Product
import com.example.shoppage.ui.theme.CenturyOldStyleBold
import com.example.shoppage.utils.annotations.HorizontalScreenPreview
import com.example.shoppage.utils.annotations.VerticalScreenPreview

@Composable
fun ProductsList(productList: List<Product>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row {
            Text(
                text = "New Products",
                fontFamily = CenturyOldStyleBold,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "See all",
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {

                })
        }
        LazyColumn { }
    }
}

@Composable
@VerticalScreenPreview
fun ProductListVertical() {
    ProductsList(productList = emptyList())
}

@Composable
@HorizontalScreenPreview
fun ProductListHorizontal() {
    ProductsList(productList = emptyList())
}