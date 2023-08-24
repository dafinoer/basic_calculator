package com.dafinrs.calculatorcompose.domains.repository


import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class CalculatorRepositoryTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    val testDispatcher = UnconfinedTestDispatcher()

    val arithmeticRepository = ArithmeticRepositoryImpl(testDispatcher)

    @Test
    fun calculateTest() {
        runTest {
            val result4 = arithmeticRepository.calculateBasicMath("10/2x3")
            Assert.assertEquals(result4, 15.0)
        }
    }

    @Test
    fun calculateComplexTest() {
        runTest {
            val result4 = arithmeticRepository.calculateBasicMath("8+12/3-2x5")
            Assert.assertEquals(result4, 2.0)
        }
    }

    @Test
    fun calculateComplexDouble() {
        runTest {
            val result4 = arithmeticRepository.calculateBasicMath("0.5x6/10-300")
            Assert.assertEquals(result4, -299.7)
        }
    }

    @Test
    fun calculatorMultiplication() {
        runTest {
            val result4 = arithmeticRepository.calculateBasicMath("10x10x10x10x0.5")
            Assert.assertEquals(result4, 5000.0)
        }
    }
}