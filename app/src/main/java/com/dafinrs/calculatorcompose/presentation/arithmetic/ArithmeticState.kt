package com.dafinrs.calculatorcompose.presentation.arithmetic

sealed class ArithmeticState {
    object Initialize : ArithmeticState()
    class Result(val result: String) : ArithmeticState()
    class InvalidArithmetic(val result: String? = null) : ArithmeticState()
    object InvalidNumber : ArithmeticState()
    object ArithmeticFailure : ArithmeticState()
}