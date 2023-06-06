package com.afauzi.feature_authentication.login.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RememberMe() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val switchState = remember { mutableStateOf(false) }
        Switch(
            checked = switchState.value,
            onCheckedChange = { checked ->
                switchState.value = checked
            }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Remember Me")
        Text(
            text = "Forgot Password",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.End,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RememberMePrev() {
    RememberMe()
}