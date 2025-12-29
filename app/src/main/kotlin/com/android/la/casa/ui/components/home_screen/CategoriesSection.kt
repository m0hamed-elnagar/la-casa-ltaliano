package com.android.la.casa.ui.components.home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Icecream
import androidx.compose.material.icons.rounded.LocalDrink
import androidx.compose.material.icons.rounded.LocalPizza
import androidx.compose.material.icons.rounded.LunchDining
import androidx.compose.material.icons.rounded.Tapas
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.la.casa.ui.screens.Category
import com.android.la.casa.ui.theme.PrimaryRed
import com.android.la.casa.ui.theme.TextDark
import com.android.la.casa.ui.theme.TextGrey

@Composable
fun CategoriesSection() {
    val categories = listOf(
        Category("Pizza", Icons.Rounded.LocalPizza, true),
        Category("Burger", Icons.Rounded.LunchDining),
        Category("Drinks", Icons.Rounded.LocalDrink),
        Category("Sides", Icons.Rounded.Tapas),
        Category("Sweets", Icons.Rounded.Icecream),
    )

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text("Category", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = TextDark)
            Text("See All", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = PrimaryRed)
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(categories) { category ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Surface(
                        shape = RoundedCornerShape(50.dp),
                        color = if (category.isSelected) PrimaryRed else Color.White,
                        shadowElevation = if (category.isSelected) 8.dp else 1.dp,
                        modifier = Modifier.size(64.dp)
                    ) {
                        Icon(
                            imageVector = category.icon,
                            contentDescription = category.name,
                            tint = if (category.isSelected) Color.White else Color.Gray,
                            modifier = Modifier
                                .padding(16.dp)
                                .size(32.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = category.name,
                        fontSize = 12.sp,
                        fontWeight = if (category.isSelected) FontWeight.Bold else FontWeight.Medium,
                        color = if (category.isSelected) TextDark else TextGrey
                    )
                }
            }
        }
    }
}