package com.pmtaller2.AuxiliadoraChinchilla_00156823.ui.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Scaffold
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pmtaller2.AuxiliadoraChinchilla_00156823.data.dummy.restaurants
import com.pmtaller2.AuxiliadoraChinchilla_00156823.ui.components.RestaurantCard
import com.pmtaller2.AuxiliadoraChinchilla_00156823.ui.theme.FoodSpotTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    //Navigation bar logic
    data class NavItem(val label: String, val icon: ImageVector, val route: String)
    val navItems = listOf(
        NavItem("Inicio", Icons.Filled.Home, "home"),
        NavItem("Busqueda", Icons.Filled.Search, "favorite"),
        NavItem("Mis Ordenes", Icons.Filled.ShoppingCart, "shoppingCart")
    )
    var selectedItem by rememberSaveable { mutableStateOf("home") }

    //Navigation logic
    val navController = rememberNavController()

    //Loading Restaurants logic
    val groupedRestaurants = restaurants.groupBy { it.categories.firstOrNull() ?: "Otros" }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = "FoodSpot") }
            )
        },
        bottomBar = {
                NavigationBar {
                    navItems.forEach { item ->
                        NavigationBarItem(
                            label = { Text(item.label) },
                            icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                            selected = selectedItem == item.route,
                            onClick = { selectedItem = item.route },
                        )
                    }
                }
        }
    ) { innerPadding ->
        LazyColumn (modifier = Modifier.padding(innerPadding)) {
            groupedRestaurants.forEach { (category, restaurants) ->
                item { Text(text = category, modifier = Modifier.padding(vertical = 8.dp)) }

                item {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        items(restaurants, key = { it.id }) { restaurant ->
                            RestaurantCard(
                                restaurant = restaurant,
                                onRestaurantClick = {},
                            )
                        }
                    }
                }

                item { HorizontalDivider(thickness = 2.dp) }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodSpotTheme {
        //HomeScreen()
    }
}