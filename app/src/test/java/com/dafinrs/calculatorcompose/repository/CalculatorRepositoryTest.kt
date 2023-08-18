package com.dafinrs.calculatorcompose.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.Assert
import org.junit.Test

class CalculatorRepositoryTest {

    private val calculatorRepository = CalculatorRepository()

    @Test
    fun calculateTest() {
        val result4 =calculatorRepository.calculateArithmetic("10/2x3")
        Assert.assertEquals(result4, "15.0")
    }

    @Test
    fun calculateComplexTest() {
        val result4 =calculatorRepository.calculateArithmetic("8+12/3-2x5")
        Assert.assertEquals(result4, "2.0")
    }

    @Test
    fun calculateComplexDouble() {
        val result4 =calculatorRepository.calculateArithmetic("0.5x6/10-300")
        Assert.assertEquals(result4, "-299.7")
    }

    @Test
    fun calculatorMultiplication() {
        val result4 =calculatorRepository.calculateArithmetic("10x10x10x10x0.5")
        Assert.assertEquals(result4, "5000.0")
    }
}