package com.example.shoppage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.shoppage.ui.theme.CenturyOldStyleBold
import com.example.shoppage.ui.theme.ShopPageTheme
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
        title = { Text(text = "Shop", fontFamily = CenturyOldStyleBold) },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

}

@VerticalScreenPreview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
