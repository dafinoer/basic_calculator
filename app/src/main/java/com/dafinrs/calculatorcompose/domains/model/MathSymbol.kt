package com.dafinrs.calculatorcompose.domains.model


enum class MathSymbol(val symbol: String) {
    PLUS_SIGN("+"), MINUS_SIGN("-"), DIVISION_SLASH("/"), TIMES_SIGN("x"),
}


fun String.toMathSymbol(): MathSymbol? {
    return when (this) {
        MathSymbol.DIVISION_SLASH.symbol -> MathSymbol.DIVISION_SLASH
        MathSymbol.PLUS_SIGN.symbol -> MathSymbol.PLUS_SIGN
        MathSymbol.MINUS_SIGN.symbol -> MathSymbol.MINUS_SIGN
        MathSymbol.TIMES_SIGN.symbol -> MathSymbol.TIMES_SIGN
        else -> null
    }
}