package devandroid.felipe.restaurantepanucci.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import devandroid.felipe.restaurantepanucci.R
import devandroid.felipe.restaurantepanucci.ui.theme.RestaurantePanucciTheme
import devandroid.felipe.restaurantepanucci.ui.uistate.ProductDetailsUiState

@Composable
fun ProductDetailsScreen(
    modifier: Modifier = Modifier,
    onOrderClick: () -> Unit = {},
    onBackClick: () -> Unit = {},
    uiState: ProductDetailsUiState = ProductDetailsUiState()
) {
    val product = uiState.product

    Column(
        modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        product.image?.let {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )
        }
        Column(
            Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(product.name, fontSize = 24.sp)
            Text(product.price.toPlainString(), fontSize = 18.sp)
            Text(product.description)
            Button(
                onClick = { onOrderClick() },
                Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text(text = "Pedir")
            }
        }
    }
}

@Preview
@Composable
fun ProductDetailsScreenPreview() {
    RestaurantePanucciTheme {
        Surface {
            ProductDetailsScreen()
        }
    }
}