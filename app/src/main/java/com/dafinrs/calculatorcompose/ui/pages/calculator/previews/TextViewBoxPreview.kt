package com.dafinrs.calculatorcompose.ui.pages.calculator.previews

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dafinrs.calculatorcompose.presentation.arithmetic.ArithmeticState
import com.dafinrs.calculatorcompose.ui.pages.calculator.components.TextViewBox
import com.dafinrs.calculatorcompose.ui.theme.CalculatorComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
private fun TextViewBoxPreview() {
    CalculatorComposeTheme {
        Scaffold {
            TextViewBox(
                modifier = Modifier.padding(it),
                mathCharacter = "10x10",
                mathResult = ArithmeticState.Initialize
            )
        }
    }
}