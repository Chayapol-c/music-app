package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.musicapp.ui.components.molecules.MoleculeMenuItem

@Composable
fun BrowseItem(category: String, drawable: Int) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .size(200.dp),
        border = BorderStroke(width = 1.dp, color = Color.DarkGray)
    ) {
        MoleculeMenuItem(
            label = category,
            icon = drawable
        )
    }
}