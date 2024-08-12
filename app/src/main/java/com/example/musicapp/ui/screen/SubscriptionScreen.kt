package com.example.musicapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.musicapp.ui.components.atoms.AtomText
import com.example.musicapp.ui.components.atoms.TextVariant

@Composable
fun SubscriptionView() {
    Column(
        modifier = Modifier.height(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AtomText(text = "Manage Subscription", variant = TextVariant.TITLE)
        Card(modifier = Modifier.padding(8.dp), elevation = 4.dp) {
            Column(modifier = Modifier.padding(8.dp)) {
                Column {
                    AtomText(text = "Musical", variant = TextVariant.LABEL)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        AtomText(text = "Free Tier", variant = TextVariant.LABEL)
                        TextButton(
                            onClick = {

                            }) {
                            Row {
                                AtomText(text = "See All Plans", variant = TextVariant.DESCRIPTION)
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                    contentDescription = "See All Plans"
                                )
                            }
                        }
                    }
                }
                Divider(thickness = 1.dp, modifier = Modifier.padding(horizontal = 8.dp))
                Row(
                    modifier = Modifier.padding(vertical = 16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountBox,
                        contentDescription = "Get a Plan"
                    )
                    AtomText(text = "Get a Plan", variant = TextVariant.DESCRIPTION)
                }
            }
        }
    }
}