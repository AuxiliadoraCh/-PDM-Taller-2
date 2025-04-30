package com.pmtaller2.AuxiliadoraChinchilla_00156823.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.pmtaller2.AuxiliadoraChinchilla_00156823.data.model.Dish
import com.pmtaller2.AuxiliadoraChinchilla_00156823.data.model.Restaurant
import com.pmtaller2.AuxiliadoraChinchilla_00156823.ui.theme.FoodSpotTheme

@Composable
fun RestaurantCard(restaurant: Restaurant, onRestaurantClick: (Int) -> Unit = {}) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.fillMaxWidth().clickable { onRestaurantClick(restaurant.id) }
    ) {
        Column (modifier = Modifier.padding(16.dp)) {
            AsyncImage(
                model= ImageRequest.Builder(LocalContext.current).data(restaurant.imageUrl).build(),
                contentDescription = restaurant.name,
                modifier = Modifier.height(120.dp).fillMaxWidth().clip(RoundedCornerShape(8.dp)),
            )

            Spacer(modifier = Modifier.width(2.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = restaurant.name,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = restaurant.description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = restaurant.categories.joinToString(" - "),
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

val restaurantPreview = Restaurant(
    id = 1,
    name = "Pizza Planet",
    description = "Las mejores pizzas del universo",
    imageUrl = "https://resizer.iproimg.com/unsafe/1280x/filters:format(webp)/https://assets.iprofesional.com/assets/jpg/2020/08/501640.jpg",
    categories = listOf("Pizzas", "Comida Italiana", "Vegetariano"),
    menu = listOf(
        Dish(
            id = 1,
            name = "Pizza Pepperoni",
            description = "Clásica pizza con pepperoni y queso.",
            imageUrl = "https://example.com/pepperoni.jpg"
        ),
        Dish(
            id = 2,
            name = "Pizza Vegetariana",
            description = "Pizza saludable con verduras frescas.",
            imageUrl = "https://example.com/veggie.jpg"
        )
    )
)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodSpotTheme {
        RestaurantCard(restaurantPreview)
    }
}