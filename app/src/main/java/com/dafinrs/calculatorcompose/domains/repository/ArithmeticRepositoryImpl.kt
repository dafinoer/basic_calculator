package com.dafinrs.calculatorcompose.domains.repository

import com.dafinrs.calculatorcompose.data.repository.ArithmeticRepository
import com.dafinrs.calculatorcompose.domains.model.MathSymbol
import com.dafinrs.calculatorcompose.domains.model.toMathSymbol
import com.dafinrs.calculatorcompose.extensions.isCharSymbol
import com.dafinrs.calculatorcompose.extensions.toArrayListMathOperation
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.withContext

class ArithmeticRepositoryImpl(private val dispatcher: CoroutineDispatcher) :
    ArithmeticRepository {

    override suspend fun calculateBasicMath(value: String): Double? {
        val resultHistory = ArrayDeque<Double>()
        val symbolHistory = arrayListOf<String>()
        var firstState = 0.0

        return withContext(dispatcher) {
            val toListFromString = value.toArrayListMathOperation()
            for (mathNumb in toListFromString) {
                ensureActive()
                val lastValue = resultHistory.lastOrNull()

                when {
                    !mathNumb.isCharSymbol() -> {
                        val charInDouble = mathNumb.toDouble()
                        val symbolMath = symbolHistory.lastOrNull()
                        val last2Symbol =
                            symbolHistory.getOrNull(symbolHistory.lastIndex - 1)?.toMathSymbol()

                        when (symbolMath?.toMathSymbol()) {
                            MathSymbol.PLUS_SIGN -> {
                                resultHistory.addLast(
                                    lastValue?.plus(charInDouble) ?: (charInDouble + firstState)
                                )
                            }

                            MathSymbol.MINUS_SIGN -> {
                                resultHistory.addLast(
                                    lastValue?.minus(charInDouble) ?: (firstState - charInDouble)
                                )
                            }

                            MathSymbol.DIVISION_SLASH -> {
                                val total = firstState / charInDouble
                                when (last2Symbol) {
                                    MathSymbol.PLUS_SIGN -> resultHistory.addLast(
                                        total.plus(resultHistory.last().minus(firstState))
                                    )

                                    MathSymbol.MINUS_SIGN -> resultHistory.addLast(
                                        resultHistory.last().plus(firstState).minus(total)
                                    )

                                    MathSymbol.DIVISION_SLASH, MathSymbol.TIMES_SIGN -> resultHistory.addLast(
                                        resultHistory.last() / charInDouble
                                    )

                                    else -> resultHistory.addLast(total)
                                }
                            }

                            MathSymbol.TIMES_SIGN -> {
                                val total = firstState * charInDouble
                                when (last2Symbol) {
                                    MathSymbol.PLUS_SIGN -> resultHistory.addLast(
                                        total.plus(
                                            resultHistory.last().minus(firstState)
                                        )
                                    )

                                    MathSymbol.MINUS_SIGN -> resultHistory.addLast(
                                        resultHistory.last().plus(firstState).minus(total)
                                    )

                                    MathSymbol.DIVISION_SLASH, MathSymbol.TIMES_SIGN -> resultHistory.addLast(
                                        resultHistory.last() * charInDouble
                                    )

                                    else -> resultHistory.addLast(total)
                                }
                            }

                            else -> Unit
                        }
                        firstState = mathNumb.toDouble()
                    }

                    else -> symbolHistory.add(mathNumb)
                }
            }

            return@withContext resultHistory.lastOrNull()
        }
    }
}