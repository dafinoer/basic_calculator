package com.dafinrs.calculatorcompose.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.koin.core.annotation.Factory
import org.koin.core.annotation.InjectedParam


class CalculatorRepository() {

    private val mathSymbol = setOf("+", "-", "x", "/")

    fun calculateAritmatic(value: String): String? {
        val resultHistory = arrayListOf<Double>()
        val toListFromString = toStringValidMath(value)
        val symbolHistory = arrayListOf<String>()
        var firstState = 0.0
        for (mathNumb in toListFromString) {
            val lastValue = if (resultHistory.isNotEmpty()) resultHistory.last() else null

            when {
                mathSymbol.contains(mathNumb) -> symbolHistory.add(mathNumb)
                !mathSymbol.contains(mathNumb) && symbolHistory.isNotEmpty() -> {
                    val charInDouble = mathNumb.toDouble()
                    val symbolMath = symbolHistory.last()

                    if (symbolMath == "+") {
                        resultHistory.add(
                            lastValue?.plus(charInDouble) ?: (charInDouble + firstState)
                        )
                    } else if (symbolMath == "-") {
                        resultHistory.add(
                            lastValue?.minus(charInDouble) ?: (firstState - charInDouble)
                        )
                    } else if (symbolMath == "/") {
                        val total = firstState / charInDouble
                        val prevResult = lastSymbol(symbolHistory, resultHistory)
                        if (prevResult == "+") {
                            resultHistory.add(
                                total.plus(
                                    resultHistory.last().minus(firstState)
                                )
                            )
                        } else if (prevResult == "-") {
                            resultHistory.add(
                                resultHistory.last().plus(firstState).minus(total)
                            )
                        } else if (prevResult == "/" || prevResult == "x") {
                            resultHistory.add(resultHistory.last() / charInDouble)
                        } else {
                            resultHistory.add(total)
                        }

                    } else if (symbolMath == "x") {
                        val total = firstState * charInDouble
                        val prevResult = lastSymbol(symbolHistory, resultHistory)
                        if (prevResult == "+") {
                            resultHistory.add(
                                total.plus(
                                    resultHistory.last().minus(firstState)
                                )
                            )
                        } else if (prevResult == "-") {
                            resultHistory.add(
                                resultHistory.last().plus(firstState).minus(total)
                            )
                        } else if (prevResult == "/" || prevResult == "x") {
                            resultHistory.add(resultHistory.last() * charInDouble)
                        } else {
                            resultHistory.add(total)
                        }
                    }
                    firstState = mathNumb.toDouble()
                }

                else -> firstState = mathNumb.toDouble()
            }
        }

        if (resultHistory.isNotEmpty()) {
            return resultHistory.last().toString()
        }
        return null
    }

    private fun toStringValidMath(value: String): ArrayList<String> {
        val toListFromString = arrayListOf<String>()
        var validDoubleString: String = ""

        for (index in value.indices) {
            if (mathSymbol.contains(value[index].toString())) {
                toListFromString.add(validDoubleString)
                toListFromString.add(value[index].toString())
                validDoubleString = ""
            } else if (index == value.lastIndex) {
                validDoubleString += value[index].toString()
                toListFromString.add(validDoubleString)
            } else {
                validDoubleString += value[index].toString()
            }
        }
        return toListFromString
    }

    private fun lastSymbol(
        symbols: ArrayList<String>,
        resultHistory: ArrayList<Double>,
    ): String? {
        if (symbols.size > 1 && resultHistory.isNotEmpty()) {
            val lastSymbol = symbols[symbols.lastIndex - 1]
            return lastSymbol
        }
        return null
    }
}