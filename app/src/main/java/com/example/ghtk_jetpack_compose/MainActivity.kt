package com.example.ghtk_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ghtk_jetpack_compose.ui.theme.Ghtk_jetpack_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ghtk_jetpack_composeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UserProfileScreen(
//                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun UserProfileScreen(modifier: Modifier) {
    Column(modifier = modifier) {
        // Header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(
                    R.drawable.ic_arrow
                ), contentDescription = null, modifier = Modifier.size(28.dp)
            )
            Box(
                modifier = Modifier.size(80.dp), contentAlignment = Alignment.Center
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    drawCircle(
                        color = Color(0xFF388E3C) // Vẽ hình tròn
                    )
                }
                BasicText(
                    text = 55.toString(), style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                )
            }
            Spacer(modifier = Modifier.width(4.dp))
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "843***4455", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.weight(1f)) // Đẩy Row thứ hai về cuối
                    Row(
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(4.dp)
                            )
                            .background(color = colorResource(R.color.primary))
                            .padding(4.dp, 0.dp, 4.dp, 0.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_heart),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(text = "Theo dõi", fontSize = 16.sp, color = Color.White)
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row {
                    Image(painter = painterResource(R.drawable.ic_check), contentDescription = null)
                    Text(text = "Đã xác thực SĐT & Địa chỉ")
                }
            }
        }

        // Tags
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp, 0.dp, 12.dp, 0.dp),
        ) {
            Spacer(modifier = Modifier.width(24.dp))
            TagItem("Đã mua", Color.White, Color.Gray)
            TagItem("Thiết bị điện tử", Color.Blue, Color.White)
            TagItem("Voucher", Color.Cyan, Color.White)
            TagItem("Thiết bị điện gia dụng", Color.Magenta, Color.White)
            TagItem("Mẹ và bé", Color.Red, Color.White)
            TagItem("Nhà cửa", Color.Green, Color.White)
        }

        // Divider
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp, 12.dp, 12.dp, 0.dp)
                .height(0.8.dp)
                .background(Color.LightGray)
        )

        // Statistics Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp, 16.dp, 12.dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                StatItem(label = "Độ cháy túi", value = "--")
            }
            Row(modifier = Modifier.padding()) {
                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(12.dp)
                        .background(Color.LightGray)
                )
            }
            Column(
                modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                StatItem(label = "ĐH đã đặt", value = "80")
            }
            Row(modifier = Modifier.padding()) {
                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(12.dp)
                        .background(Color.LightGray)
                )
            }
            Column(
                modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                StatItem(label = "Thành công", value = "--")
            }
            Row(modifier = Modifier.padding()) {
                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(12.dp)
                        .background(Color.LightGray)
                )
            }
            Column(
                modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(R.drawable.ic_rocket),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(text = "Tên lửa", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    }
                    Text(text = "Tốc độ nhận", color = Color.Gray, fontSize = 12.sp)
                }
            }
        }

        // Divider
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp, 16.dp, 12.dp, 0.dp)
                .height(0.8.dp)
                .background(Color.LightGray)
        )

        // Actions Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp, 16.dp, 12.dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                StatItem(label = "Đánh giá", value = "38 😍 10 😠")
            }
            Box(
                modifier = Modifier
                    .width(1.dp)
                    .height(12.dp)
                    .background(Color.LightGray)
            )
            Column(
                modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                StatItem(label = "Đã ghé thăm", value = "10 Shop")
            }
            Box(
                modifier = Modifier
                    .width(1.dp)
                    .height(12.dp)
                    .background(Color.LightGray)
            )
            Column(
                modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                StatItem(label = "Đã mua", value = "11 Shop")
            }
            Box(
                modifier = Modifier
                    .width(1.dp)
                    .height(12.dp)
                    .background(Color.LightGray)
            )
            Column(
                modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                StatItem(label = "Chu kỳ mua", value = "--")
            }
        }

        // Divider
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 12.dp, 0.dp, 0.dp)
                .height(8.dp)
                .background(Color.LightGray)
        )

        // Tabs (Hoạt động, Nhận hàng, 2lanstore)
        TabRow(
            selectedTabIndex = 0
        ) {
            Tab(modifier = Modifier.padding(0.dp, 12.dp, 0.dp, 12.dp),
                selected = true,
                selectedContentColor = colorResource(R.color.primary),
                onClick = { /*TODO*/ }) {
                Text(
                    text = "Hoạt động",
                )
            }
            Tab(modifier = Modifier.weight(3f),
                selected = false,
                selectedContentColor = colorResource(R.color.primary),
                onClick = { /*TODO*/ }) {
                Text(
                    text = "Nhận hàng", color = Color.Black
                )
            }
            Tab(modifier = Modifier.weight(3f),
                selectedContentColor = colorResource(R.color.primary),
                selected = false,
                onClick = { /*TODO*/ }) {
                Text(
                    text = "2lanstore",
                    color = Color.Black,
                )
            }
            Tab(selected = false, onClick = { /*TODO*/ })
        }

        Row {
            // List of Orders
            LazyColumn(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
                    .weight(3f)
            ) {
                items(10) {
                    OrderItem(
                        text = "YEAHHH! hai đã đặt hàng sản phẩm Giá trị cao", date = "10/10/2023"
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(0.dp, 0.dp, 12.dp, 0.dp)
            ) {
                Column(
                    modifier = Modifier
                        .background(color = colorResource(R.color.primary))
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row {
                        Image(
                            painter = painterResource(R.drawable.ic_phone),
                            contentDescription = null
                        )
                        Text(text = "(3)", color = Color.White, fontSize = 12.sp)
                    }
                    Text(text = "Gọi điện", color = Color.White)
                }
                Spacer(Modifier.height(1.dp))
                Column(
                    modifier = Modifier
                        .background(color = colorResource(R.color.primary))
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painter = painterResource(R.drawable.ic_chat), contentDescription = null)
                    Text(text = "Gọi điện", color = Color.White)
                }
                Spacer(Modifier.height(1.dp))
                Column(
                    modifier = Modifier
                        .background(color = colorResource(R.color.primary))
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painter = painterResource(R.drawable.ic_add), contentDescription = null)
                    Text(text = "Gọi điện", color = Color.White)
                }
                Spacer(Modifier.height(1.dp))
                Column(
                    modifier = Modifier
                        .background(color = colorResource(R.color.primary))
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painter = painterResource(R.drawable.ic_star), contentDescription = null)
                    Text(text = "Gọi điện", color = Color.White)
                }
            }
        }

    }
}


@Composable
fun TagItem(tag: String, backgroundColor: Color, textColor: Color) {
    Row(modifier = Modifier.padding(2.dp)) {
        Text(
            text = tag,
            modifier = Modifier
                .clip(
                    RoundedCornerShape(4.dp)
                )
                .background(backgroundColor)
                .padding(4.dp, 0.dp, 4.dp, 0.dp),
            color = textColor,
        )
    }


}

@Composable
fun StatItem(label: String, value: String) {
    Column() {
        Text(text = value, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Text(text = label, color = Color.Gray, fontSize = 12.sp)
    }
}

@Composable
fun OrderItem(text: String, date: String) {
    Row(modifier = Modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        Text(modifier = Modifier.weight(3f), text = text)
        Text(modifier = Modifier.weight(1f), text = date, color = Color.Gray, fontSize = 12.sp, fontStyle = FontStyle.Italic)
    }
    // Divider
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .height(0.8.dp)
            .background(Color.LightGray)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ghtk_jetpack_composeTheme {
        UserProfileScreen(modifier = Modifier)
    }
}