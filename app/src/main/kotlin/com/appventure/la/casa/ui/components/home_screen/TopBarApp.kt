package com.appventure.la.casa.ui.components.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appventure.la.casa.ui.theme.PrimaryRed
import com.appventure.la.casa.ui.theme.SecondaryDark
import com.appventure.la.casa.ui.theme.TextDark
import com.appventure.la.casa.R

@Composable
fun TopBarApp() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(PrimaryRed),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Rounded.AccountCircle, contentDescription = "Account", tint = Color.White)
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = "Good Morning, Ahmed",
                    fontSize = 18.sp,
                    color = TextDark,
                    fontFamily = FontFamily(
                        Font(R.font.work_sans_bold, FontWeight.Normal)),
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon( painterResource(id = R.drawable.ic_location),
                        contentDescription = "Location",
                        tint = PrimaryRed,
                        modifier = Modifier.size(18.dp)
                    )
                    Text(
                        text = "Cairo, EG",
                        fontSize = 14.sp,
                        color = PrimaryRed
                    )
                }
            }
        }

        Box {
            Surface(
                shape = CircleShape,
                color = Color.White,
                shadowElevation = 4.dp,
                modifier = Modifier.size(40.dp)
            ) {
                Icon(
                    Icons.Rounded.Notifications,
                    contentDescription = "Cart",
                    modifier = Modifier.padding(8.dp),
                    tint = SecondaryDark
                )
            }
            // Badge
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(x = 2.dp, y = (-2).dp)
                    .size(16.dp)
                    .clip(CircleShape)
                    .background(PrimaryRed)
                    .border(2.dp, Color.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text("2", color = Color.White, fontSize = 8.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}