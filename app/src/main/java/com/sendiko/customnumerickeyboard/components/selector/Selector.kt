package com.sendiko.customnumerickeyboard.components.selector

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Selector(
    modifier: Modifier = Modifier,
    onSelect: (TextFieldMode) -> Unit,
    currentSelected: TextFieldMode
) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.surfaceContainerHigh)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            SelectorButton(
                modifier = Modifier.weight(1f),
                text = "Single",
                isActive = currentSelected == TextFieldMode.Single,
                onClick = {
                    onSelect(TextFieldMode.Single)
                }
            )
            SelectorButton(
                modifier = Modifier.weight(1f),
                text = "Multiple",
                isActive = currentSelected == TextFieldMode.Multiple,
                onClick = {
                    onSelect(TextFieldMode.Multiple)

                }
            )
        }
    }
}

@Preview
@Composable
private fun SelectorPrev() {
    Surface {
        Selector(
            onSelect = {

            },
            currentSelected = TextFieldMode.Multiple
        )
    }
}