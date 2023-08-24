package com.dafinrs.calculatorcompose.presentation.typing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.dafinrs.calculatorcompose.domains.model.MathSymbol


@Composable
fun rememberEditTextState(
    initialState: String
): EditTextMathState {
    return remember { EditTextMathState(initialState) }
}

class EditTextMathState(initialText: String) {
    val textState = mutableStateOf(initialText)

    var isAddSymbol = false
        get() = field

    var isDouble = false

    fun isValidateCalculate() = !isAddSymbol && textState.value.isNotEmpty()

    fun addText(value: String) {
        isAddSymbol = false
        textState.value = textState.value.plus(value)
    }

    fun addSymbol(value: MathSymbol) {
        if (isAddSymbol) {
            dropLast(value.symbol)
        } else {
            isAddSymbol = true
            textState.value = textState.value.plus(value.symbol)
        }
        isDouble = false
    }

    fun onReset() {
        textState.value = ""
        isAddSymbol = false
        isDouble = false
    }

    fun onAddDouble() {
        if (!isDouble && textState.value.isNotEmpty()) {
            textState.value = textState.value.plus('.')
            isDouble = true
        }
    }

    private fun dropLast(newValue: String) {
        textState.value = textState.value.dropLast(1).let { it + newValue }
    }
}