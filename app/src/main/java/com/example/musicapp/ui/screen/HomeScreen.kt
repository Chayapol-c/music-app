package com.example.musicapp.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.musicapp.R
import com.example.musicapp.ui.components.atoms.AtomText
import com.example.musicapp.ui.components.atoms.TextVariant
import com.example.musicapp.ui.components.organisms.BrowseItem

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
                AtomText(
                    text = it.value[0],
                    modifier = Modifier.padding(16.dp),
                    variant = TextVariant.TITLE
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

