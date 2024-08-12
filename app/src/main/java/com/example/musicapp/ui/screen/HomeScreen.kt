package com.example.musicapp.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.musicapp.R
import com.example.musicapp.ui.components.molecules.BrowseItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeView() {
    val categories = listOf("Hits", "Happy", "Workout", "Running", "TGIF", "Yoga")
    val grouped = listOf("New Release", "Favourites", "Top Rated").groupBy { it[0] }
    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        grouped.forEach {
            stickyHeader {
                Text(
                    text = it.value[0],
                    modifier = Modifier.padding(16.dp)
                )
                LazyRow {
                    items(categories) {
                        BrowseItem(
                            category = it,
                            drawable = R.drawable.ic_browse
                        )
                    }
                }
            }

        }

    }
}

