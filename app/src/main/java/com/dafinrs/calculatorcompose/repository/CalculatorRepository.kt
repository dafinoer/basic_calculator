package com.dafinrs.calculatorcompose.repository

class CalculatorRepository {

    private val mathSymbol = setOf("+", "-", "x", "/")

    fun calculateArithmetic(value: String): String? {
        val resultHistory = ArrayDeque<Double>()
        val toListFromString = toStringValidMath(value)
        val symbolHistory = arrayListOf<String>()
        var firstState = 0.0
        for (mathNumb in toListFromString) {
            val lastValue = resultHistory.lastOrNull()

            when {
                !mathSymbol.contains(mathNumb) -> {
                    val charInDouble = mathNumb.toDouble()
                    val symbolMath = symbolHistory.lastOrNull()

                    if (symbolMath == "+") {
                        resultHistory.addLast(
                            lastValue?.plus(charInDouble) ?: (charInDouble + firstState)
                        )
                    } else if (symbolMath == "-") {
                        resultHistory.addLast(
                            lastValue?.minus(charInDouble) ?: (firstState - charInDouble)
                        )
                    } else if (symbolMath == "/") {
                        val total = firstState / charInDouble
                        when (lastSymbol(symbolHistory)) {
                            "+" -> {
                                resultHistory.addLast(
                                    total.plus(resultHistory.last().minus(firstState))
                                )
                            }

                            "-" -> {
                                resultHistory.addLast(
                                    resultHistory.last().plus(firstState).minus(total)
                                )
                            }

                            "/", "x" -> {
                                resultHistory.addLast(resultHistory.last() / charInDouble)
                            }

                            else -> resultHistory.addLast(total)
                        }
                    } else if (symbolMath == "x") {
                        val total = firstState * charInDouble
                        when (lastSymbol(symbolHistory)) {
                            "+" -> {
                                resultHistory.addLast(
                                    total.plus(
                                        resultHistory.last().minus(firstState)
                                    )
                                )
                            }

                            "-" -> {
                                resultHistory.addLast(
                                    resultHistory.last().plus(firstState).minus(total)
                                )
                            }

                            "x", "/" -> {
                                resultHistory.addLast(resultHistory.last() * charInDouble)
                            }

                            else -> resultHistory.addLast(total)
                        }
                    }
                    firstState = mathNumb.toDouble()
                }

                else -> symbolHistory.add(mathNumb)
            }
        }

        if (resultHistory.isNotEmpty()) {
            return resultHistory.last().toString()
        }

        return null
    }

    private fun toStringValidMath(value: String): ArrayList<String> {
        val toListFromString = arrayListOf<String>()
        var validDoubleString = ""

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

    private fun lastSymbol(symbols: ArrayList<String>): String? {
        if (symbols.size > 1) {
            return symbols[symbols.lastIndex - 1]
        }
        return null
    }
}