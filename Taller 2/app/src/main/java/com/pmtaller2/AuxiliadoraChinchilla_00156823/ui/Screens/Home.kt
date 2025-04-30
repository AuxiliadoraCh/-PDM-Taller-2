package com.pmtaller2.AuxiliadoraChinchilla_00156823.ui.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Scaffold
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.pmtaller2.AuxiliadoraChinchilla_00156823.ui.theme.FoodSpotTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = "FoodSpot") }
            )
        }
    ) { innerPadding ->
        Column (modifier = Modifier.padding(innerPadding)) {
            Text(text = "� Comida Rápida")
            Column(modifier = Modifier.padding(10.dp)) {

            }
            HorizontalDivider(thickness = 5.dp)
            Text(text = "� Comida Mexicana")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodSpotTheme {
        HomeScreen()
    }
}