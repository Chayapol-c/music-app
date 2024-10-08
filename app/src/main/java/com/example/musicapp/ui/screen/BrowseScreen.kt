package com.example.musicapp.ui.screen

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import com.example.musicapp.R
import com.example.musicapp.ui.components.molecules.BrowseItem

@Composable
fun BrowseView() {
    val categories = listOf("Hits", "Happy", "Workout", "Running", "TGIF", "Yoga")
    LazyVerticalGrid(GridCells.Fixed(2)) {
        items(categories) {
            BrowseItem(
                category = it,
                drawable = R.drawable.ic_browse
            )

        }
    }
}