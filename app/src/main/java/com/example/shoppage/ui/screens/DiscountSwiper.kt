package com.example.shoppage.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppage.R
import com.example.shoppage.data.Discount
import com.example.shoppage.ui.theme.Neon
import com.example.shoppage.utils.annotations.VerticalScreenPreview

@Composable
fun DiscountSwiper(discountList: List<Discount>, modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { discountList.size })
    HorizontalPager(
        state = pagerState,
        modifier = modifier
    ) { page ->
        Box {
            Image(
                painter = painterResource(R.drawable.banner_card), contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxWidth()
            )
            Column(modifier = Modifier.padding(horizontal = 42.dp, vertical = 32.dp)) {
                Text(
                    text = discountList[page].title,
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = discountList[page].subTitle,
                    color = Color.White,
                    fontSize = 16.sp,
                )
                Spacer(modifier = Modifier.size(50.dp))
                Card(
                    colors = CardDefaults.cardColors(containerColor = Neon),
                ) { Text(text = discountList[page].dateString, modifier = Modifier.padding(4.dp)) }
            }
        }
    }
}

@Composable
@VerticalScreenPreview
fun DiscountSwiperVerticalPreview() {
    DiscountSwiper(discountList = List(3) { Discount() })
}