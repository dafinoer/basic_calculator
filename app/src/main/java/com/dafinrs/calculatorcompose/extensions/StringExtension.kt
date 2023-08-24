package com.dafinrs.calculatorcompose.extensions

import com.dafinrs.calculatorcompose.domains.model.MathSymbol


fun String.toArrayListMathOperation(): ArrayList<String> {
    val toListFromString = arrayListOf<String>()
    var validDoubleString = ""

    for (index in this.indices) {
        if (this[index].toString().isCharSymbol()) {
            toListFromString.add(validDoubleString)
            toListFromString.add(this[index].toString())
            validDoubleString = ""
        } else if (index == this.lastIndex) {
            validDoubleString += this[index].toString()
            toListFromString.add(validDoubleString)
        } else {
            validDoubleString += this[index].toString()
        }
    }
    return toListFromString
}


fun String.isCharSymbol(): Boolean {
    return when (this) {
        MathSymbol.TIMES_SIGN.symbol,
        MathSymbol.MINUS_SIGN.symbol,
        MathSymbol.PLUS_SIGN.symbol,
        MathSymbol.DIVISION_SLASH.symbol,
        -> true

        else -> false
    }
}