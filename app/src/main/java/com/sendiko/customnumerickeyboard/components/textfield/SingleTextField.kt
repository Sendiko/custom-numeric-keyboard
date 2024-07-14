package com.sendiko.customnumerickeyboard.components.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SingleTextField(
    modifier: Modifier = Modifier,
    value: String,
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        value = value,
        onValueChange = {},
        readOnly = true,
        placeholder = {
            Text(text = "Type some number..")
        },
        supportingText = {
            Text(text = "*This textfield is read only, start typing using the keyboard below")
        }
    )
}