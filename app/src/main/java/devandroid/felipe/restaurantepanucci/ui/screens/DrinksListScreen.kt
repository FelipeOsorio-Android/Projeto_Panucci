package devandroid.felipe.restaurantepanucci.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import devandroid.felipe.restaurantepanucci.model.ProductModel
import devandroid.felipe.restaurantepanucci.sampledata.sampleProducts
import devandroid.felipe.restaurantepanucci.ui.components.DrinkProductCard
import devandroid.felipe.restaurantepanucci.ui.theme.RestaurantePanucciTheme
import devandroid.felipe.restaurantepanucci.ui.theme.caveatFont

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DrinksListScreen(
    modifier: Modifier = Modifier,
    title: String = "Bebidas",
    products: List<ProductModel> = emptyList(),
    columns: Int = 2,
) {
    Column(
        modifier
            .fillMaxSize()
    ) {
        Surface {
            Text(
                text = title,
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                fontFamily = caveatFont,
                fontSize = 32.sp,
                textAlign = TextAlign.Center
            )
        }
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(columns),
            Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalItemSpacing = 16.dp
        ) {
            items(products) { p ->
                DrinkProductCard(
                    product = p
                )
            }
        }
    }
}

@Preview
@Composable
fun DrinksListScreenPreview() {
    RestaurantePanucciTheme {
        Surface {
            DrinksListScreen(
                products = sampleProducts,
                title = "Bebidas"
            )
        }
    }
}