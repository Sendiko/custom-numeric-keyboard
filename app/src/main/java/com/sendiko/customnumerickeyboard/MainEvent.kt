package com.sendiko.customnumerickeyboard

import com.sendiko.customnumerickeyboard.components.keyboard.KeyboardAction
import com.sendiko.customnumerickeyboard.components.selector.TextFieldMode

sealed class MainEvent {
    data class OnNumberInput(val number: String): MainEvent()
    data class OnSymbolInput(val symbol: String): MainEvent()
    data class OnAction(val keyboardAction: KeyboardAction): MainEvent()
    data class OnChangeMode(val textFieldMode: TextFieldMode): MainEvent()
}