package dev.berggren

import androidx.compose.material.Slider
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi

@Composable
@ExperimentalComposeUiApi
fun SliderScreen() {
    var callCounter by remember { mutableStateOf(0) }
    var value by remember { mutableStateOf(0f) }
    Slider(
        value = value,
        onValueChange = { value = it },
        onValueChangeFinished = {
            callCounter += 1
            println("onValueChangeFinished called $callCounter times")
        }
    )
}