package com.androsaces.wineabago.winelist.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androsaces.wineabago.Wine
import com.androsaces.wineabago.winelist.view.ui.theme.WineabagoTheme

class WineList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WineabagoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val wines = listOf(
                        Wine("Penfolds Grange", "2016", "South Australia"),
                        Wine("Domaine de la Romanée-Conti", "2015", "Burgundy"),
                        Wine("Screaming Eagle Cabernet Sauvignon", "2018", "Napa Valley"),
                        Wine("Jacob's Creek St Hugo Cabernet", "Coonawarra", "2016")
                    )
                    WineList(wines = wines, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun WineList(wines: List<Wine>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(wines) { wine ->
            WineRow(wine = wine)
        }
    }
}

@Composable
fun WineRow(wine: Wine, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = wine.name, fontWeight = FontWeight.SemiBold)
        Row(Modifier.fillMaxWidth()) {
            Text(text = wine.region, color = Color.Gray, fontWeight = FontWeight.Light)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = wine.vintage)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WineListPreview() {
    WineabagoTheme {
        val wines = listOf(
            Wine("Penfolds Grange", "2016", "South Australia"),
            Wine("Domaine de la Romanée-Conti", "2015", "Burgundy"),
            Wine("Domaine de la Romanée-Conti", "2016", "Burgundy"),
            Wine("Screaming Eagle Cabernet Sauvignon", "2018", "Napa Valley")
        )
        WineList(wines)
    }
}
