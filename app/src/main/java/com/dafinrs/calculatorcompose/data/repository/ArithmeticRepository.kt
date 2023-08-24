package com.dafinrs.calculatorcompose.data.repository

interface ArithmeticRepository {

    suspend fun calculateBasicMath(value: String): Double?
}