package com.jkv.cryptotracker.presentation.coinlist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(onToggle: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(id = com.jkv.cryptotracker.R.string.greeting),
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.primary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(id = com.jkv.cryptotracker.R.string.greeting_msg),
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.primary
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 24.dp, 36.dp, 0.dp),
            horizontalArrangement = Arrangement.End
        ) {
            WigglesThemeSwitch(onToggle = { onToggle() })
        }
    }
}

@Composable
fun WigglesThemeSwitch(onToggle: () -> Unit) {

    val icon = if (isSystemInDarkTheme())
        painterResource(id = com.jkv.cryptotracker.R.drawable.ic_light_off)
    else
        painterResource(id = com.jkv.cryptotracker.R.drawable.ic_light_on)

    Icon(
        painter = icon,
        contentDescription = null,
        modifier = Modifier
            .size(24.dp, 24.dp)
            .clickable(onClick = onToggle),
        tint = colorResource(id = com.jkv.cryptotracker.R.color.text)
    )
}