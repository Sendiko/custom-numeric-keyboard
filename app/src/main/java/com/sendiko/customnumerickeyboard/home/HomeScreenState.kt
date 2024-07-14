package com.sendiko.customnumerickeyboard.home

import com.sendiko.customnumerickeyboard.components.selector.TextFieldMode

data class HomeScreenState(
    val numberText: String = "",
    val textFieldMode: TextFieldMode = TextFieldMode.Single,
    val numberOfTextField: Int = 6,
)
