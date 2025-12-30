package com.appventure.la.casa.ui.components.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.appventure.la.casa.R
import com.appventure.la.casa.ui.screens.profile_screen.AppColor
import com.appventure.la.casa.ui.theme.PrimaryRed
import com.appventure.la.casa.ui.theme.SecondaryDark
import com.appventure.la.casa.ui.theme.TextDark

@Composable
fun TopBarApp(
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.clickable(onClick = onProfileClick)
            ) {
                AsyncImage(
                    model = "https://lh3.googleusercontent.com/aida-public/AB6AXuC8DThqHwzwmtEz31F8cNnUEvN-Ad7yjRq2u-6ntQwZ65IKqQF2CfTNIbLxRoUsrqqFn8-geGnb9kF1ou8K3F_l6fr6vlK1xdQ7TH5MzimWdsnMH9ylNg2SINRuFxXKRQTyeFBX65EFUt1uw0RVAMlHkHhhti1zclFf4ZXlmmJXqewoDz4gS0RkoWlwwM6l1ZhvsrHkVZmuE6-T-e2eWHU_eGq1BgQcnvTFXRLgtWKXFTLhQql40k5yPXWuEjX5OMtG2E6EJSgsC5c",
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .border(1.dp, AppColor.Primary.copy(alpha = .1f), CircleShape),
                    contentScale = ContentScale.Crop
                )
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
                Row(
                    modifier = Modifier.padding(top = 4.dp),
                    verticalAlignment = Alignment.CenterVertically) {
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
                    Icon(
                        painterResource(id = R.drawable.ic_arrow_drop_down),
                        tint = PrimaryRed,
                        contentDescription = "Location",
                        modifier = Modifier.size(22.dp)
                    )
                }
            }
        }

        Box(modifier = Modifier.clickable(onClick = onNotificationsClick)) {
            Surface(
                shape = CircleShape,
                color = Color.White,
                shadowElevation = 4.dp,
                modifier = Modifier.size(45.dp)
            ) {
                Icon(
                    Icons.Rounded.Notifications,
                    contentDescription = "Cart",
                    modifier = Modifier.padding(8.dp)
                        .size(28.dp),
                    tint = SecondaryDark
                )
            }
            // Badge
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(x = 2.dp, y = (-2).dp)
                    .size(18.dp)
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
