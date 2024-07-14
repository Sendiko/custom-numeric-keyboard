package com.sendiko.customnumerickeyboard.components.textfield

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IndividualTextField(
    modifier: Modifier = Modifier,
    value: String,
    index: Int
) {
    val char = getChar(value, index)
    val outlineColor = if (char.isNullOrBlank()) MaterialTheme.colorScheme.outline
    else MaterialTheme.colorScheme.primary
    Box(
        modifier = modifier
        .border(width = 1.dp, color = outlineColor, shape = RoundedCornerShape(4.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (char.isNullOrBlank()) "0" else char,
            modifier = Modifier.padding(8.dp),
            fontSize = 24.sp
        )
    }
}

fun getChar(string: String, index: Int): String? {
    val cleanedvalue = string.replace(" ", "")
    var newChar: String? = ""

    newChar = try {
        cleanedvalue[index].toString()
    } catch (e: StringIndexOutOfBoundsException) {
        null
    }
    return newChar
}