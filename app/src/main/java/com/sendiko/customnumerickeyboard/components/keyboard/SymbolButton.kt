package com.sendiko.customnumerickeyboard.components.keyboard

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.sendiko.customnumerickeyboard.components.keyboard.ButtonType.*

@Composable
fun SymbolButton(
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit,
    icon: ImageVector,
    contentDescription: String = "",
    value: String,
    type: ButtonType = Secondary
) {
    val containerColor = when(type) {
        Primary -> MaterialTheme.colorScheme.primaryContainer
        Secondary -> MaterialTheme.colorScheme.secondaryContainer
        Tertiary -> MaterialTheme.colorScheme.tertiaryContainer
    }
    val contentColor = when(type) {
        Primary -> MaterialTheme.colorScheme.onPrimaryContainer
        Secondary -> MaterialTheme.colorScheme.onSecondaryContainer
        Tertiary -> MaterialTheme.colorScheme.onTertiaryContainer
    }
    Button(
        modifier = modifier,
        onClick = { onClick(value) },
        content = {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                modifier = Modifier.size(26.dp)
            )
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    )
}