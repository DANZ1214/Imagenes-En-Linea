package com.example.imagenesonline

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.imagenesonline.ui.theme.ImagenesOnlineTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImagenesOnlineTheme {
                Scaffold(
                    topBar = { Top() },
                    content = { paddingValues ->
                        ImageCards(Modifier.padding(paddingValues))
                    }
                )
            }
        }
    }
}

val imageUrls = listOf(
    "https://s.france24.com/media/display/451ed2b8-eed6-11ea-afdd-005056bf87d6/w:980/p:16x9/messi-1805.jpg",
    "https://www.fcbarcelona.com/fcbarcelona/photo/2022/08/02/ae5252d1-b79b-4950-9e34-6e67fac09bb0/LeoMessi20092010_pic_fcb-arsenal62.jpg",
    "https://media.newyorker.com/photos/64bc4330ef09d4a0e04cb249/master/pass/Rosen-Messi-Miami.jpg",
    "https://www.fcbarcelona.com/photo-resources/2020/04/30/43337a9f-3781-4886-948c-f70912e4b1af/1920x1080_Messi_primerGol-min.jpg?width=1200&height=750",
    "https://depauliaonline.com/wp-content/uploads/2021/09/IMG_5087-1-600x900.jpg"
)


@Composable
fun ImageCards(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        items(imageUrls) { imageUrl ->
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    AsyncImage(
                        model = imageUrl,
                        contentDescription = "Messi el mejor del World",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )
                    Text(
                        text = "Messi el mejor del World ${Random.nextInt(10)}",
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Top() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White
        ),
        title = { Text("El GOAT") }
    )
}


