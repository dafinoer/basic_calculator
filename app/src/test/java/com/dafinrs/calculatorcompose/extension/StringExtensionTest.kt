package com.dafinrs.calculatorcompose.extension

import com.dafinrs.calculatorcompose.extensions.isCharSymbol
import org.junit.Assert
import org.junit.Test

class StringExtensionTest {

    @Test
    fun validateTestSymbolMath() {
        val result = "+".isCharSymbol()
        Assert.assertEquals(result, true)
    }
}