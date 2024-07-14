package com.sendiko.customnumerickeyboard.components.keyboard

sealed class InputTypeEvent {
    data class OnNumberInput(val number: String): InputTypeEvent()
    data class OnSymbolInput(val symbol: String): InputTypeEvent()
    data class OnAction(val keyboardAction: KeyboardAction): InputTypeEvent()
}