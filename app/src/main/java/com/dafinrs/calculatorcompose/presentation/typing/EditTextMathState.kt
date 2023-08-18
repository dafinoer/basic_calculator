package com.dafinrs.calculatorcompose.presentation.typing

import android.view.KeyEvent.DispatcherState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.dafinrs.calculatorcompose.model.MathSymbol
import com.dafinrs.calculatorcompose.model.toMathSymbol
import com.dafinrs.calculatorcompose.repository.CalculatorRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map


@Composable
fun rememberEditTextState(
    initialState: String,
    calculatorRepository: CalculatorRepository,
): EditTextMathState {
    return remember {
        EditTextMathState(
            initialState,
            calculatorRepository,
        )
    }
}

class EditTextMathState(
    initialText: String, val calculatorRepository: CalculatorRepository
) {
    val textState = mutableStateOf(initialText)
    val resultState = mutableStateOf("")
    var isAddSymbol = false
    private val resultHistory = MutableSharedFlow<String>(replay = 1)

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
    }

    fun onReset() {
        textState.value = ""
        resultState.value = ""
        isAddSymbol = false
    }

    fun onResult() {
        if (!isAddSymbol) {
            val result = calculatorRepository.calculateAritmatic(textState.value)
            if (result != null) {
                resultState.value = result
            }
        }
    }

    private fun dropLast(newValue: Char) {
        textState.value = textState.value.dropLast(1).let { it + newValue }
    }
}