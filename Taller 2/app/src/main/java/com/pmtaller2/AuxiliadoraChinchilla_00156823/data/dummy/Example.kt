package com.pmtaller2.AuxiliadoraChinchilla_00156823.data.dummy

import com.pmtaller2.AuxiliadoraChinchilla_00156823.data.model.Dish
import com.pmtaller2.AuxiliadoraChinchilla_00156823.data.model.Restaurant

val restaurants = listOf(
    Restaurant(
        id = 1,
        name = "Pizza Planet",
        description = "Las mejores pizzas del universo",
        imageUrl = "https://example.com/pizza.jpg",
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
    ),
    Restaurant(
        id = 2,
        name = "Burger King Kong",
        description = "Las hamburguesas más monstruosas",
        imageUrl = "https://example.com/burger.jpg",
        categories = listOf("Pizzas", "Comida Italiana", "Vegetariano"),
        menu = listOf(
            Dish(
                id = 3,
                name = "Hamburguesa Doble Queso",
                description = "Doble carne, doble queso, doble sabor.",
                imageUrl = "https://example.com/doublecheese.jpg"
            ),
            Dish(
                id = 4,
                name = "Hamburguesa Vegana",
                description = "Una opción deliciosa y saludable.",
                imageUrl = "https://example.com/veganburger.jpg"
            )
        )
    )
)
