package com.example.musicapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.musicapp.R
import com.example.musicapp.ui.components.atoms.AtomText
import com.example.musicapp.ui.components.atoms.TextVariant

@Composable
fun AccountView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row() {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Account",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Column {
                    AtomText("", variant = TextVariant.DESCRIPTION)
                    AtomText("", variant = TextVariant.DESCRIPTION)
                }
                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = "Next"
                    )
                }
            }
        }

        Row(modifier = Modifier.padding(top = 16.dp)) {
            Icon(
                painter = painterResource(R.drawable.ic_music_player),
                contentDescription = "My Music",
                modifier = Modifier.padding(end = 8.dp)
            )
            AtomText(text = "My Music", variant = TextVariant.TITLE)
        }
        Divider()
    }
}