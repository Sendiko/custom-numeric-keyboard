package com.sendiko.customnumerickeyboard.components.textfield

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MultipleTextField(
    modifier: Modifier = Modifier,
    value: String,
    numberOfTextField: Int
) {
    val message = if (value.length == numberOfTextField) {
        "*Max Character Reached"
    } else "*Example with Multiple Textfield"
    Column {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
        ) {
            (1..numberOfTextField).forEach {
                IndividualTextField(value = value, index = it - 1)
            }
        }
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = message,
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview
@Composable
private fun MultipleTextFieldPrev() {
    Surface {
        MultipleTextField(value = "12", numberOfTextField = 6)
    }
}