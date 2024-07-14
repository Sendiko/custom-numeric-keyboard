package com.sendiko.customnumerickeyboard

import com.sendiko.customnumerickeyboard.components.selector.TextFieldMode

data class MainState(
    val numberText: String = "",
    val textFieldMode: TextFieldMode = TextFieldMode.Single,
    val numberOfTextField: Int = 6,
)
