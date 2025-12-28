package com.androsaces.wineabago

import android.content.ContentValues
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.data.Group
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androsaces.wineabago.ui.theme.WineabagoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WineabagoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WineList(
                        wines = getSampleWines().sortedBy { it.name },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun getSampleWines(): List<Wine> {
        return listOf(
//            Wine("Jacob's Creek St Hugo Cabernet Sauvignon", "2016", "Coonawarra"),
//            Wine("Shark's Block McLaren Vale Shiraz", "2016"),
//            Wine("Black Wattle Mt Benson Cabernet", "2017"),
//            Wine("Vasarelli Pasquale's Selection McLaren Vale Cabernet Cab Franc Merlot", "2017"),
//            Wine("Domaine Deliance Givry Premier Cru Clos Charlé", "2018"),
//            Wine("Richard Hamilton Centurain McLaren Vale Shiraz", "2017"),
//            Wine("Black Wattle Icon Mt Benson Chardonnay", "2017"),
//            Wine("Z Wines Section 3146 Barossa Valley Shiraz", "2012"),
//            Wine("Pizzini Wines Nonna Gisella King Valley Sangiovese", "2019"),
//            Wine("Pizzini Wines La Volpe King Valley Nebbiolo", "2021"),
//            Wine("Pizzini Wines King Valley Barbera", "2021"),
//            Wine("Leeuwin Estate Art Series Margaret River Cabernet Sauvignon", "2016"),
//            Wine("Hentley Farm The Beauty Barossa Valley Shiraz", "2020"),
//            Wine("Domaine de Mauperthuis Bourgogne Grande Reserve Chardonnay", "2020"),
//            Wine("Domaine de Mauperthuis Petit Chablis", "2019"),
//            Wine("Oliver's Taranga Brioni's Blend McLaren Vale Mataro, Touriga Shiraz", "2022"),
//            Wine("Domaine du Beauregard Bourgogne Hautes Cotes de Beaune", "2019"),
//            Wine("Domaine du Beauregard Bourgogne", "2019"),
//            Wine("Cháteau Lafleur du Roy", "2018"),
//            Wine("Château Palais Cardinal Saint-Émillon Grand Cru", "2020"),
        )
    }
}

@Composable
fun WineList(wines: List<Wine>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(wines) { wine ->
            WineItem(wine = wine)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun WineItem(wine: Wine, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Text(
            text = wine.name,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 4.dp),
            softWrap = false,
            overflow = TextOverflow.Ellipsis
        )
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = wine.region,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(16.dp, 4.dp, 16.dp, 16.dp)
            )
            Text(
                text = wine.vintage,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(16.dp, 4.dp, 16.dp, 16.dp)
            )

        }

    }
}

@Preview(showBackground = true)
@Composable
fun WineListPreview() {
    val sampleWines = listOf(
        Wine("St Hugo Cabernet", "2016", "Coonawarra"),
        Wine("Shark's Block Shiraz", "2016", "McLaren Vale"),
        Wine("Black Wattle Cabernet", "2017", "Mt Benson"),
        Wine("Vasarelli Pasquale's Selection Cabernet Cab Franc Merlot", "2017", "McLaren Vale"),
        Wine("Domaine Deliance Givry Premier Cru Clos Charlé", "2018", "Givry AOC"),
        Wine("Richard Hamilton Centurian Shiraz", "2017", "McLaren Vale"),
        Wine("Black Wattle Icon Chardonnay", "2017", "Mt Benson"),
//        Wine("Z Wines Section 3146 Barossa Valley Shiraz", "2012"),
//        Wine("Pizzini Wines Nonna Gisella King Valley Sangiovese", "2019"),
//        Wine("Pizzini Wines La Volpe King Valley Nebbiolo", "2021"),
//        Wine("Pizzini Wines King Valley Barbera", "2021"),
//        Wine("Leeuwin Estate Art Series Margaret River Cabernet Sauvignon", "2016"),
//        Wine("Hentley Farm The Beauty Barossa Valley Shiraz", "2020"),
//        Wine("Domaine de Mauperthuis Bourgogne Grande Reserve Chardonnay", "2020"),
//        Wine("Domaine de Mauperthuis Petit Chablis", "2019"),
//        Wine("Oliver's Taranga Brioni's Blend McLaren Vale Mataro, Touriga Shiraz", "2022"),
//        Wine("Domaine du Beauregard Bourgogne Hautes Cotes de Beaune", "2019"),
//        Wine("Domaine du Beauregard Bourgogne", "2019"),
//        Wine("Cháteau Lafleur du Roy", "2018"),
//        Wine("Château Palais Cardinal Saint-Émillon Grand Cru", "2020"),
    )

    WineabagoTheme {
        WineList(wines = sampleWines)
    }
}
