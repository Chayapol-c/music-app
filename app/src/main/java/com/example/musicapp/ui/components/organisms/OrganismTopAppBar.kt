package com.example.musicapp.ui.components.organisms

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import com.example.musicapp.ui.components.molecules.MoleculeIconButton

@Composable
fun OrganismTopAppBar(
    title: String,
    onNavigationClick: () -> Unit,
    onActionClick: () -> Unit
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            MoleculeIconButton(
                description = "Menu",
                iconVector = Icons.Default.AccountCircle,
                onClick = {
                    onNavigationClick.invoke()
                }
            )
        },
        actions = {
            MoleculeIconButton(
                description = "Menu",
                iconVector = Icons.Default.MoreVert,
                onClick = {
                    onActionClick.invoke()
                }
            )
        }
    )
}