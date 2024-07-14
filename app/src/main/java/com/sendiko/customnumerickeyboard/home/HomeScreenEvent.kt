package com.sendiko.customnumerickeyboard.home

import com.sendiko.customnumerickeyboard.components.keyboard.KeyboardAction
import com.sendiko.customnumerickeyboard.components.selector.TextFieldMode

sealed class HomeScreenEvent {
    data class OnNumberInput(val number: String): HomeScreenEvent()
    data class OnSymbolInput(val symbol: String): HomeScreenEvent()
    data class OnAction(val keyboardAction: KeyboardAction): HomeScreenEvent()
    data class OnChangeMode(val textFieldMode: TextFieldMode): HomeScreenEvent()
}