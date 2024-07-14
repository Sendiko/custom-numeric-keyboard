package com.sendiko.customnumerickeyboard

import android.util.Log
import androidx.lifecycle.ViewModel
import com.sendiko.customnumerickeyboard.components.keyboard.KeyboardAction.Backspace
import com.sendiko.customnumerickeyboard.components.keyboard.KeyboardAction.Proceed
import com.sendiko.customnumerickeyboard.components.selector.TextFieldMode
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel: ViewModel() {

    private val _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    fun onEvent(event: MainEvent) {
        when(event) {
            is MainEvent.OnAction -> {
                when(event.keyboardAction) {
                    Backspace -> _state.update {
                        it.copy(numberText = it.numberText.dropLast(1))
                    }
                    Proceed -> {
                        Log.i("PROCEED", "onEvent: Proceed")
                    }
                }
            }
            is MainEvent.OnNumberInput -> {
                if (state.value.textFieldMode == TextFieldMode.Multiple && state.value.numberText.length == state.value.numberOfTextField) {
                    return
                } else _state.update {
                    it.copy(numberText = it.numberText + event.number)
                }
            }
            is MainEvent.OnSymbolInput -> if (state.value.textFieldMode == TextFieldMode.Single) {
                _state.update {
                    it.copy(numberText = it.numberText + event.symbol)
                }
            }

            is MainEvent.OnChangeMode -> _state.update {
                it.copy(textFieldMode = event.textFieldMode)
            }
        }
    }
}