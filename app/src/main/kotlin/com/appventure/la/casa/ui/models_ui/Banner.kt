package com.appventure.la.casa.ui.models_ui

data class Banner (
    val badge: String,
    val title: String,
    val buttonTitle: String,
    val image: String
)

val BannerList = listOf(
    // Build Your Own
    Banner(
        badge = "Build Your Own Pizza",
        title = "Create your perfect pizza from scratch!",
        buttonTitle = "Start Building",
        image = "https://images.unsplash.com/photo-1574071318508-1cdbab80d002?w=600"
    ),
    // Half Price Deal
    Banner(
        badge = "Double Delight Deal",
        title = "50% OFF on your second pizza!",
        buttonTitle = "Order Now",
        image = "https://images.unsplash.com/photo-1513104890138-7c749659a591?w=600"
    ),
    // Family Combo
    Banner(
        badge = "Family Combo",
        title = "Get a large pizza for only $20!",
        buttonTitle = "Order Now",
        image = "https://images.unsplash.com/photo-1593560704563-f176a2eb61db?w=600"
    ),
    // Summer Lunch
    Banner(
        badge = "Summer Lunch Special",
        title = "Light meal for a sunny day\n Free Drink + Pizza",
        buttonTitle = "Order Now",
        image = "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?w=600"
    ),
    // Salad Offer
    Banner(
        badge = "Fresh Garden Salads",
        title = "Freshly picked ingredients for a healthy side",
        buttonTitle = "Order Now",
        image = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?w=600"
    )
)