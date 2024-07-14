package com.sendiko.customnumerickeyboard.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sendiko.customnumerickeyboard.components.keyboard.NumericKeyboard
import com.sendiko.customnumerickeyboard.components.selector.Selector
import com.sendiko.customnumerickeyboard.components.selector.TextFieldMode
import com.sendiko.customnumerickeyboard.components.textfield.MultipleTextField
import com.sendiko.customnumerickeyboard.components.textfield.SingleTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    state: HomeScreenState,
    onEvent: (HomeScreenEvent) -> Unit,
    onNavigate: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            LargeTopAppBar(
                title = { Text(text = "Custom Numeric Keyboard") },
                actions = {
                    IconButton(onClick = onNavigate) {
                        Icon(imageVector = Icons.Rounded.Info, contentDescription = "about")
                    }
                }
            )
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
                    onEvent(HomeScreenEvent.OnChangeMode(it))
                },
                currentSelected = state.textFieldMode
            )
            NumericKeyboard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                onInput = {
                    onEvent(it)
                }
            )
        }
    }
}