package com.android.la.casa.ui.components.home_screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.android.la.casa.ui.screens.BannerItem
import com.android.la.casa.ui.theme.PrimaryRed
import com.android.la.casa.ui.theme.PrimaryYellow
import com.android.la.casa.ui.theme.SecondaryDark
import com.kotlin.lacasa.R

@Composable
fun BannerSection() {
    val items = listOf(
        BannerItem(
            "CUSTOMIZE",
            "Build Your\nOwn Pizza",
            "Start Building",
            "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?w=500&auto=format&fit=crop&q=60"
        ),
        BannerItem(
            "LIMITED OFFER",
            "2 Large Pizzas \nFor Only $20",
            "Order Now",
            "https://images.unsplash.com/photo-1513104890138-7c749659a591?w=500"
        ),
        BannerItem(
            "LIMITED OFFER",
            "Summer Lunch\n" +
                    "Deal",
            null,
            "https://images.unsplash.com/photo-1513104890138-7c749659a591?w=500"
        ),
    )

    Box(modifier = Modifier.padding(vertical = 12.dp)) {
        LazyRow {
            items(items) { banner ->
                BannerCard(banner)
            }
        }
    }

}

@Composable
fun BannerCard(banner: BannerItem) {
    Box(modifier = Modifier
        .padding(horizontal = 8.dp)
        .width(330.dp)) {
        Card(
            colors = CardDefaults.cardColors(containerColor = SecondaryDark),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Box {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(0.70f)) {
                        Surface(
                            color = PrimaryRed.copy(alpha = 0.15f),
                            shape = RoundedCornerShape(50),
                            modifier = Modifier.padding(bottom = 8.dp)
                        ) {
                            Text(
                                text = banner.badge,
                                color = PrimaryYellow,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                            )
                        }
                        Text(
                            text = banner.title,
                            color = Color.White,
                            maxLines = 2,
                            fontFamily = FontFamily(
                                Font(R.font.work_sans_bold)
                            ),
                            fontSize = 24.sp,
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        banner.buttonTitle?.let {
                            Button(
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White.copy(
                                        alpha = 0.2f
                                    )
                                ),
                                shape = RoundedCornerShape(24.dp),
                                contentPadding = PaddingValues(horizontal = 18.dp, vertical = 4.dp),
                                modifier = Modifier.height(32.dp)
                            ) {
                                Text(banner.buttonTitle, fontSize = 12.sp, color = Color.White)
                            }
                        }

                    }
                    Spacer(modifier = Modifier.weight(0.30f))
                }

                // Image
                AsyncImage(
                    model = banner.image,
                    contentDescription = "Offer Pizza",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset(x = 40.dp)
                        .size(150.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.White.copy(0.2f), CircleShape)
                )
            }
        }
    }
}