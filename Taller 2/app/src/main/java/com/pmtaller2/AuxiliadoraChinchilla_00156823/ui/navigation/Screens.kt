package com.pmtaller2.AuxiliadoraChinchilla_00156823.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object HomeScreen

@Serializable
object SearchScreen

@Serializable
object OrdersScreen

@Serializable
data class MenuScreen(val restaurantName: String)

@Serializable
data class MovieDetailScreen(val id: Int)