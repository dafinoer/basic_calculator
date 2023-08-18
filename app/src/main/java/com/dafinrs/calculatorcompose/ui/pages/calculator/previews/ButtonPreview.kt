package com.dafinrs.calculatorcompose.ui.pages.calculator.previews

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dafinrs.calculatorcompose.ui.pages.calculator.ButtonCalculator
import com.dafinrs.calculatorcompose.ui.theme.CalculatorComposeTheme

@Preview(showBackground = true)
@Composable
private fun ButtonPreview() {
    CalculatorComposeTheme {
        ButtonCalculator(
            onTap = {

            },
            sizeHeight = 50.dp,
            sizeWidth = 50.dp,
            color = MaterialTheme.colorScheme.surfaceVariant,
            child = {
                Text(
                    text = "X",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center,
                )
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ButtonPreviewDark() {
    CalculatorComposeTheme(darkTheme = true) {
        ButtonCalculator(
            onTap = {

            },
            sizeHeight = 50.dp,
            sizeWidth = 50.dp,
            color = MaterialTheme.colorScheme.surface,
        ) {
            Text("+", color = MaterialTheme.colorScheme.onSurface)
        }
    }
}