package com.sendiko.customnumerickeyboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Backspace
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.automirrored.rounded.Backspace
import androidx.compose.material.icons.rounded.Backspace
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.material.icons.rounded.SpaceBar
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sendiko.customnumerickeyboard.ui.theme.CustomNumericKeyboardTheme

@Composable
fun NumericKeyboard(
    modifier: Modifier = Modifier,
    onInput: (InputTypeEvent) -> Unit,
) {
    val padding = 4.dp
    Surface {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(padding)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(padding),
                verticalAlignment = Alignment.CenterVertically
            ) {
                NumericButton(
                    value = 1,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        onInput(InputTypeEvent.OnNumberInput(it.toString()))
                    }
                )
                NumericButton(
                    value = 2,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        onInput(InputTypeEvent.OnNumberInput(it.toString()))
                    }
                )
                NumericButton(
                    value = 3,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        onInput(InputTypeEvent.OnNumberInput(it.toString()))
                    }
                )
                SymbolButton(
                    modifier = Modifier.weight(1f),
                    onClick = { onInput(InputTypeEvent.OnSymbolInput(it)) },
                    icon = Icons.Rounded.Remove,
                    value = "-",
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(padding),
                verticalAlignment = Alignment.CenterVertically
            ) {
                NumericButton(
                    value = 4,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        onInput(InputTypeEvent.OnNumberInput(it.toString()))
                    }
                )
                NumericButton(
                    value = 5,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        onInput(InputTypeEvent.OnNumberInput(it.toString()))
                    }
                )
                NumericButton(
                    value = 6,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        onInput(InputTypeEvent.OnNumberInput(it.toString()))
                    }
                )
                SymbolButton(
                    modifier = Modifier.weight(1f),
                    onClick = { onInput(InputTypeEvent.OnSymbolInput(it)) },
                    icon = Icons.Rounded.SpaceBar,
                    value = " "
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(padding),
                verticalAlignment = Alignment.CenterVertically
            ) {
                NumericButton(
                    value = 7,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        onInput(InputTypeEvent.OnNumberInput(it.toString()))
                    }
                )
                NumericButton(
                    value = 8,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        onInput(InputTypeEvent.OnNumberInput(it.toString()))
                    }
                )
                NumericButton(
                    value = 9,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        onInput(InputTypeEvent.OnNumberInput(it.toString()))
                    }
                )
                SymbolButton(
                    modifier = Modifier.weight(1f),
                    onClick = { onInput(InputTypeEvent.OnAction(KeyboardAction.Backspace)) },
                    icon = Icons.AutoMirrored.Outlined.Backspace,
                    value = "BackSpace",
                    type = ButtonType.Tertiary
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(padding),
                verticalAlignment = Alignment.CenterVertically
            ) {
                NonNumericButton(
                    label = ",",
                    modifier = Modifier.weight(1f),
                    onClick = {
                        onInput(InputTypeEvent.OnSymbolInput(it))
                    }
                )
                NumericButton(
                    value = 0,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        onInput(InputTypeEvent.OnNumberInput(it.toString()))
                    }
                )
                NonNumericButton(
                    label = ".",
                    modifier = Modifier.weight(1f),
                    onClick = {
                        onInput(InputTypeEvent.OnSymbolInput(it))
                    }
                )
                SymbolButton(
                    modifier = Modifier.weight(1f),
                    onClick = { onInput(InputTypeEvent.OnAction(KeyboardAction.Proceed)) },
                    icon = Icons.AutoMirrored.Rounded.ArrowForward,
                    value = "BackSpace",
                    type = ButtonType.Primary
                )
            }
        }
    }
}

@Preview
@Composable
private fun NumericKeyboardPrev() {
    CustomNumericKeyboardTheme(
        darkTheme = true
    ) {
        NumericKeyboard(
            onInput = { },
            modifier = Modifier.padding(8.dp)
        )
    }
}