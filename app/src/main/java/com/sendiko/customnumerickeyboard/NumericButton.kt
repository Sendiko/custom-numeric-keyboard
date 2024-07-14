package com.sendiko.customnumerickeyboard

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun NumericButton(
    modifier: Modifier = Modifier,
    value: Int,
    onClick: (Int) -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = { onClick(value) },
        content = {
            Text(
                text = "$value",
                fontSize = 24.sp
            )
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    )
}

@Preview
@Composable
private fun NumericButtonPrev() {
    NumericButton(value = 1) {

    }
}