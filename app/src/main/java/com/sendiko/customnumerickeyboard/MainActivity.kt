package com.sendiko.customnumerickeyboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sendiko.customnumerickeyboard.components.keyboard.NumericKeyboard
import com.sendiko.customnumerickeyboard.components.selector.Selector
import com.sendiko.customnumerickeyboard.components.selector.TextFieldMode
import com.sendiko.customnumerickeyboard.components.textfield.MultipleTextField
import com.sendiko.customnumerickeyboard.components.textfield.SingleTextField
import com.sendiko.customnumerickeyboard.ui.theme.CustomNumericKeyboardTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CustomNumericKeyboardTheme {
                val viewModel = viewModel<MainViewModel>()
                val state by viewModel.state.collectAsState()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        LargeTopAppBar(title = { Text(text = "Custom Numeric Keyboard") })
                    }
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        AnimatedVisibility(
                            visible = state.textFieldMode == TextFieldMode.Single,
                        ) {
                            SingleTextField(value = state.numberText)
                        }
                        AnimatedVisibility(
                            visible = state.textFieldMode == TextFieldMode.Multiple,
                        ) {
                            MultipleTextField(
                                value = state.numberText,
                                modifier = Modifier.padding(16.dp),
                                numberOfTextField = state.numberOfTextField
                            )
                        }
                        Selector(
                            onSelect = {
                                viewModel.onEvent(MainEvent.OnChangeMode(it))
                            },
                            currentSelected = state.textFieldMode
                        )
                        NumericKeyboard(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            onInput = {
                                viewModel.onEvent(it)
                            }
                        )
                    }
                }
            }
        }
    }
}