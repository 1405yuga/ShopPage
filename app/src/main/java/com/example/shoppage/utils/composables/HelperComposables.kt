package com.example.shoppage.utils.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.example.shoppage.ui.theme.Gold
import com.example.shoppage.utils.annotations.VerticalScreenPreview

@Composable
fun StarRating(rating: Int) {
    Row {
        repeat(5) { index ->
            Icon(
                imageVector = if (index < rating) Icons.Filled.Star else Icons.Outlined.StarBorder,
                contentDescription = "ratings",
                tint = Gold
            )
        }
    }
}

@VerticalScreenPreview
@Composable
fun StarRatingPreview() {
    StarRating(3)
}