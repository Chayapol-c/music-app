package com.example.musicapp.ui.molecules

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainBottomSheetItem(
    info: MainBottomSheetInfo,
    modifier: Modifier
) {
    Row(modifier = modifier.padding(16.dp)) {
        Icon(
            modifier = Modifier.padding(end = 8.dp),
            painter = painterResource(info.icon),
            contentDescription = "setting"
        )
        Text(text = info.title, fontSize = 20.sp, color = Color.White)
    }
}