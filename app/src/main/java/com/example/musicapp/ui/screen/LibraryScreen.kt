package com.example.musicapp.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.musicapp.domain.library.libraries
import com.example.musicapp.ui.components.organisms.OrganismLibraryItem

@Composable
fun LibraryScreen() {
    LazyColumn {
        items(libraries) {
            OrganismLibraryItem(it)
        }
    }
}
