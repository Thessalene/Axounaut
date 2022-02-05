package com.example.presentation

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.Article
import com.example.presentation.ui.theme.*

class HomeComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AxounautTheme {
                Scaffold(
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = { /* ... */ },
                            backgroundColor = green_light_1,
                            contentColor = white
                        ) {
                            Icon(Icons.Filled.Add,"")
                        }
                    }
                ) {
                    Column(
                        modifier = Modifier.background(orange_light)
                    ) {
                        Header()
                        Spacer(modifier = Modifier.height(15.dp))
                        Column(
                            verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp, vertical = 0.dp)
                        ) {
                            HomeCard("Mes commandes")
                            HomeCard("Mon stock")
                        }
                        HomeItem()
                    }
                }

            }
        }
    }
}

@Composable
fun Header() {
    Surface(
        color = MaterialTheme.colors.background,
        shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp),
        elevation = 20.dp,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.6f)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                Modifier
                    .fillMaxHeight(0.3f)
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_kb),
                    contentDescription = "Logo Application",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp)
            ) {
                RoundedCounter("45", "Total commandes")
                RoundedCounter("565,0€", "CA")
                RoundedCounter("75,0€", "Réductions")
            }
            LazyRow(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                val liste = listOf(
                    Article(0L, "Pain au choco", 30.5, 15),
                    Article(0L, "Pomme cannelle", 30.5, 1),
                    Article(0L, "Rolls Kanèls", 30.5, 42),
                    Article(0L, "Chocolat", 30.5, 65),
                    Article(0L, "Flan au coco", 30.5, 20),
                    Article(0L, "Petits pains", 30.5, 15),
                    Article(0L, "Petits pains fourrés boeuf", 30.5, 15),
                )

                items(liste) { item ->
                    ArticleBar(item)
                }
            }
        }
    }
}

@Composable
fun RoundedCounter(count: String, description: String, isCircle: Boolean = false) {
    Box(
        modifier = Modifier
            .clip(if (isCircle) CircleShape else RoundedCornerShape(35.dp))
            .background(gray_0)
            .padding(start = 18.dp, end = 18.dp, top = 10.dp, bottom = 10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = description, fontSize = 6.sp, fontFamily = Typography.body1.fontFamily)
            Text(
                text = count,
                color = ginger,
                fontSize = 25.sp,
                fontFamily = Typography.body1.fontFamily
            )
        }
    }
}

@Composable
fun ArticleBar(article: Article, totalCount: Int = 100) {
    Log.d(TAG, "ArticleBar: ${article.label} § Count : ${article.timeOrdered / totalCount}")
    val boxSize = 65.dp
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                .background(gray_0)
                .width(boxSize)
                .fillMaxHeight(0.9f)
        ) {

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                    .background(orange_002)
                    .width(boxSize)
                    .height(50.dp)
                    .align(Alignment.BottomCenter)
            )
        }
        Text(
            text = article.label,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.requiredWidth(boxSize),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun HomeCard(title: String) {
    Card(
        shape = RoundedCornerShape(18.dp),
        elevation = 15.dp,
        backgroundColor = gray_0,
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = title,
                fontFamily = Typography.body1.fontFamily,
                modifier = Modifier.padding(15.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_right_arrow),
                contentDescription = "Right arrow",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 15.dp)
            )

        }
    }
}

@Composable
fun HomeItem() {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .background(blue_001)
    ) {
        // TODO
    }
}


@Preview(showBackground = true, device = Devices.PIXEL_2)
@Composable
fun DefaultPreview() {
    AxounautTheme {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /* ... */ },
                    backgroundColor = green_light_1,
                    contentColor = white
                ) {
                    Icon(Icons.Filled.Add,"")
                }
            }
        ) {
            Column(
                modifier = Modifier.background(orange_light)
            ) {
                Header()
                Spacer(modifier = Modifier.height(15.dp))
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 0.dp)
                ) {
                    HomeCard("Mes commandes")
                    HomeCard("Mon stock")
                }
                HomeItem()
            }
        }

    }
}