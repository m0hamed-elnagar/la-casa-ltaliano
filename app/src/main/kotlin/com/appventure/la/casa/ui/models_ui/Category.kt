package com.appventure.la.casa.ui.models_ui

import androidx.compose.ui.graphics.vector.ImageVector

data class Category(
    val name: String,
    val icon: ImageVector,
    val isSelected: Boolean = false
)