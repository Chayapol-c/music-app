package com.example.musicapp.ui.components.atoms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AtomTextFieldGroup(
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        content()
    }
}