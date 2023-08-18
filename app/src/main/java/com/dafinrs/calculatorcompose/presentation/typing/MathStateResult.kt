package com.dafinrs.calculatorcompose.presentation.typing

sealed class MathStateResult(val result: String? = null) {
    class Invalid(): MathStateResult("Invalid")
    class Initialize(): MathStateResult(null)
    class Result(val resultValue: String): MathStateResult(resultValue)
}
