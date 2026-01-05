package com.appventure.la.casa.ui.models_ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocalPizza
import androidx.compose.material.icons.rounded.Icecream
import androidx.compose.material.icons.rounded.LocalDrink
import androidx.compose.material.icons.rounded.LunchDining
import androidx.compose.material.icons.rounded.Tapas
import androidx.compose.ui.graphics.vector.ImageVector

data class Category(
    val name: String,
    val icon: ImageVector,
    val isSelected: Boolean = false
)

val CategoriesList = listOf(
    Category("Pizza", Icons.Outlined.LocalPizza, isSelected = true),
    Category("Burger", Icons.Rounded.LunchDining),
    Category("Drinks", Icons.Rounded.LocalDrink),
    Category("Sides", Icons.Rounded.Tapas),
    Category("Sweets", Icons.Rounded.Icecream),
)