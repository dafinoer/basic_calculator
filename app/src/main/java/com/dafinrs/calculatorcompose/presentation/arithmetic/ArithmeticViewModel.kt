package com.dafinrs.calculatorcompose.presentation.arithmetic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dafinrs.calculatorcompose.data.repository.ArithmeticRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.InjectedParam
import java.lang.NumberFormatException


@KoinViewModel
class ArithmeticViewModel(@InjectedParam private val arithmeticRepository: ArithmeticRepository) :
    ViewModel() {

    private val arithmeticState = MutableStateFlow<ArithmeticState>(ArithmeticState.Initialize)

    val arithmeticUiState = arithmeticState.asStateFlow()

    fun calculate(value: String) {
        viewModelScope.launch {
            try {
                val result = arithmeticRepository.calculateBasicMath(value)
                if (result != null) {
                    arithmeticState.value = ArithmeticState.Result(result.toString())
                }
            } catch (arithmeticException: ArithmeticException) {
                arithmeticState.value =
                    ArithmeticState.InvalidArithmetic(arithmeticException.message)
            } catch (numberException: NumberFormatException) {
                arithmeticState.value = ArithmeticState.InvalidNumber
            } catch (exception: Exception) {
                arithmeticState.value = ArithmeticState.ArithmeticFailure
            }
        }
    }

    fun setToIdle() {
        arithmeticState.value = ArithmeticState.Initialize
    }
}