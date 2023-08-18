package com.dafinrs.calculatorcompose.model


enum class MathSymbol(val symbol: Char) {
    TAMBAH('+'), KURANG('-'), BAGI('/'), KALI('x'),
}

fun Char.toMathSymbol(): MathSymbol? {
    return when (this) {
        MathSymbol.KALI.symbol -> MathSymbol.KALI
        MathSymbol.KURANG.symbol -> MathSymbol.KURANG
        MathSymbol.TAMBAH.symbol -> MathSymbol.TAMBAH
        MathSymbol.BAGI.symbol -> MathSymbol.BAGI
        else -> null
    }
}