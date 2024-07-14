package com.sendiko.customnumerickeyboard.components.keyboard

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun NonNumericButton(
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit,
    label: String
) {
    Button(
        modifier = modifier,
        onClick = { onClick(label) },
        content = {
            Text(
                text = label,
                fontSize = 24.sp
            )
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    )
}