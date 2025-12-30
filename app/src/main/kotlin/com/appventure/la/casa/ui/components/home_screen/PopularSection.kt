package com.appventure.la.casa.ui.components.home_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.appventure.la.casa.ui.screens.PizzaItem
import com.appventure.la.casa.ui.theme.PrimaryRed
import com.appventure.la.casa.ui.theme.TextDark
import com.appventure.la.casa.ui.theme.TextGrey


@Composable
fun PopularSection() {
    val items = listOf(
        PizzaItem("Double Pepperoni", "Extra mozzarella, pepperoni", 14.50, 4.8, "https://images.unsplash.com/photo-1628840042765-356cda07504e?w=500"),
        PizzaItem("Veggie Supreme", "Bell peppers, olives, onion", 12.00, 4.5, "https://images.unsplash.com/photo-1574071318508-1cdbab80d002?w=500"),
        PizzaItem("BBQ Chicken", "BBQ sauce, chicken, onions", 15.50, 4.9, "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?w=500")
    )

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Popular Now", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = TextDark)
            Text("See All", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = PrimaryRed)
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(items) { pizza ->
                PopularCard(pizza)
            }
        }
    }
}

@Composable
fun PopularCard(pizza: PizzaItem) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.width(200.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Box {
                AsyncImage(
                    model = pizza.image,
                    contentDescription = pizza.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                Surface(
                    color = Color.White,
                    shape = RoundedCornerShape(6.dp),
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Icon(Icons.Rounded.Star, null, tint = Color(0xFFFFD700), modifier = Modifier.size(10.dp))
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(pizza.rating.toString(), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = pizza.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = pizza.description,
                fontSize = 12.sp,
                color = TextGrey,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$${pizza.price}0",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = PrimaryRed
                )

                Surface(
                    shape = CircleShape,
                    color = PrimaryRed,
                    modifier = Modifier
                        .size(28.dp)
                        .clickable { }
                ) {
                    Icon(Icons.Rounded.Add, null, tint = Color.White, modifier = Modifier.padding(4.dp))
                }
            }
        }
    }
}