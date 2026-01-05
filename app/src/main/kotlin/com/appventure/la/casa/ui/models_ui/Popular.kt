package com.appventure.la.casa.ui.models_ui

data class Popular(
    val name: String,
    val description: String,
    val price: Double,
    val rating: Double,
    val image: String
)

val PopularList = listOf(
    Popular(
        "Double Pepperoni",
        "Extra mozzarella, pepperoni",
        14.50,
        4.8,
        "https://images.unsplash.com/photo-1628840042765-356cda07504e?w=500"
    ),
    Popular(
        "Veggie Supreme",
        "Bell peppers, olives, onion",
        12.00,
        4.5,
        "https://images.unsplash.com/photo-1574071318508-1cdbab80d002?w=500"
    ),
    Popular(
        "BBQ Chicken",
        "BBQ sauce, chicken, onions",
        15.50,
        4.9,
        "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?w=500"
    )
)
