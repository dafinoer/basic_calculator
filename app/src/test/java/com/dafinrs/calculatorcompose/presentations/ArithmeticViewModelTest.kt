package com.dafinrs.calculatorcompose.presentations

import com.dafinrs.calculatorcompose.domains.repository.ArithmeticRepositoryImpl
import com.dafinrs.calculatorcompose.presentation.arithmetic.ArithmeticState
import com.dafinrs.calculatorcompose.presentation.arithmetic.ArithmeticViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Test

class ArithmeticViewModelTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testBasicMath() {
        runTest {
            val testDispatcher = UnconfinedTestDispatcher()
            Dispatchers.setMain(testDispatcher)
            val arithmeticRepository = ArithmeticRepositoryImpl(testDispatcher)
            val arithmeticViewModel = ArithmeticViewModel(arithmeticRepository)
            arithmeticViewModel.calculate("10x10")

            when(arithmeticViewModel.arithmeticUiState.value) {
                is ArithmeticState.Result -> {
                    val result = arithmeticViewModel.arithmeticUiState.value as ArithmeticState.Result
                    Assert.assertEquals(result.result, "100.0")
                }
                else -> AssertionError("error")
            }
        }
    }
}