package com.example.shoppage.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.shoppage.R
import com.example.shoppage.data.Category
import com.example.shoppage.ui.theme.CenturyOldStyleTextStyle
import com.example.shoppage.utils.annotations.VerticalScreenPreview

@Composable
fun CategoryList(
    categoryList: List<Category>,
    onCategoryClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(modifier = modifier.padding(bottom = 16.dp)) {
            Text(
                text = "Categories",
                style = CenturyOldStyleTextStyle,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "See all",
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {

                })
        }

        LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            items(categoryList) { category ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Card(
                        onClick = { onCategoryClick() },
                        shape = CircleShape,
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Black
                        )
                    ) {
                        Image(
                            painter = painterResource(R.drawable.categorysample),
                            contentDescription = null,
                            modifier = Modifier.size(80.dp)
                        )
                    }
                    Text(text = category.categoryName)
                }
            }
        }
    }
}

@Composable
@VerticalScreenPreview
fun CategoryListVerticalPreview() {
    CategoryList(
        categoryList = List(6) { Category() },
        onCategoryClick = {}
    )
}