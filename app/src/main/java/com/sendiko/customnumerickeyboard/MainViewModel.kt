package com.sendiko.customnumerickeyboard

import android.util.Log
import androidx.lifecycle.ViewModel
import com.sendiko.customnumerickeyboard.components.keyboard.InputTypeEvent
import com.sendiko.customnumerickeyboard.components.keyboard.KeyboardAction.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel: ViewModel() {

    private val _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    fun onEvent(event: InputTypeEvent) {
        when(event) {
            is InputTypeEvent.OnAction -> {
                when(event.keyboardAction) {
                    Backspace -> _state.update {
                        it.copy(numberText = it.numberText.dropLast(1))
                    }
                    Proceed -> {
                        Log.i("PROCEED", "onEvent: Proceed")
                    }
                }
            }
            is InputTypeEvent.OnNumberInput -> _state.update {
                it.copy(numberText = it.numberText + event.number)
            }
            is InputTypeEvent.OnSymbolInput -> _state.update {
                it.copy(numberText = it.numberText + event.symbol)
            }
        }
    }
}