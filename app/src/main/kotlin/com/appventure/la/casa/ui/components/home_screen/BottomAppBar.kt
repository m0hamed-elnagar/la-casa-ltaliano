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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appventure.la.casa.ui.theme.BackgroundLight
import com.appventure.la.casa.ui.theme.LightCafe
import com.appventure.la.casa.ui.theme.PrimaryRed
import com.appventure.la.casa.R

@Preview
@Composable
fun BottomAppBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 0.dp)
            .height(70.dp)
    ) {
        Surface(
            color = Color.White,
            shape = RoundedCornerShape(0.dp),
            shadowElevation = 10.dp,
            modifier = Modifier.fillMaxSize().align(Alignment.BottomCenter)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BottomNavItem(R.drawable.ic_home_fill, "Home", true)
                BottomNavItem(R.drawable.ic_favorite_outlined, "Favorite", false)
                Spacer(modifier = Modifier.width(30.dp))
                BottomNavItem(R.drawable.ic_moped_outlined, "Orders", false)
                BottomNavItem(R.drawable.ic_category_outlined, "Category", false)
            }
        }

        Surface(
            color = PrimaryRed,
            shape = CircleShape,
            shadowElevation = 8.dp,
            border = Border(2.dp, BackgroundLight),
            modifier = Modifier
                .size(64.dp)
                .align(Alignment.TopCenter)
                .offset(y = (-20).dp)
        ) {
            Icon(
                Icons.Rounded.ShoppingBag,
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun BottomNavItem(icon:Int, label: String, isSelected: Boolean) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable {  }
    ) {
        Icon(
            painterResource(icon),
            contentDescription = label,
            tint = if (isSelected) PrimaryRed else LightCafe,
            modifier = Modifier.size(26.dp)
        )
        if (isSelected) {
            Text(label, fontSize = 10.sp, color = PrimaryRed, fontWeight = FontWeight.Bold)
        }
    }
}

// دالة مساعدة لرسم حدود حول الزر العائم لمحاكاة الـ "Cutout"
fun Border(width: Dp, color: Color) = BorderStroke(width, color)

