package com.appventure.la.casa.ui.components.home_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingBag
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appventure.la.casa.R
import com.appventure.la.casa.ui.theme.LightCafe
import com.appventure.la.casa.ui.theme.PrimaryRed


data class NavItem(
    val label: String,
    val route: String,
    val selectedIcon: Int,
    val unselectedIcon: Int
)

@Composable
fun BottomAppBar(
    items: List<NavItem>,
    currentRoute: String,
    onItemClick: (String) -> Unit,
    onCartClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
    ) {
        Surface(
            color = MaterialTheme.colorScheme.surface,
            shape = RoundedCornerShape(0.dp),
            shadowElevation = 10.dp,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val navItems = items.filter { it.route != "cart" }

                navItems.take(2).forEach { item ->
                    BottomNavItem(
                        item = item,
                        isSelected = item.route == currentRoute,
                        onClick = { onItemClick(item.route) }
                    )
                }

                Spacer(modifier = Modifier.width(40.dp))

                navItems.drop(2).forEach { item ->
                    BottomNavItem(
                        item = item,
                        isSelected = item.route == currentRoute,
                        onClick = { onItemClick(item.route) }
                    )
                }
            }
        }

        // Cart button
        Surface(
            onClick = onCartClick,
            color = PrimaryRed,
            shape = CircleShape,
            shadowElevation = 8.dp,
            border = FabBorder(2.dp, MaterialTheme.colorScheme.surface),
            modifier = Modifier
                .size(64.dp)
                .align(Alignment.TopCenter)
                .offset(y = (-18).dp)
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Icon(
                    Icons.Rounded.ShoppingBag,
                    contentDescription = "Cart",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}

@Composable
private fun BottomNavItem(
    item: NavItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val icon = if (isSelected) item.selectedIcon else item.unselectedIcon
    val contentColor = if (isSelected) PrimaryRed else LightCafe
    val fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp, horizontal = 4.dp)
    ) {
        Icon(
            painterResource(icon),
            contentDescription = item.label,
            tint = contentColor,
            modifier = Modifier.size(28.dp)
        )
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            text = item.label,
            fontSize = 12.sp,
            color = contentColor,
            fontWeight = fontWeight,
            maxLines = 1
        )
    }
}

private fun FabBorder(width: Dp, color: Color) = BorderStroke(width, color)
