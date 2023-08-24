package com.dafinrs.calculatorcompose.ui.pages.calculator.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.dafinrs.calculatorcompose.R
import com.dafinrs.calculatorcompose.presentation.arithmetic.ArithmeticState


@Composable
fun TextViewBox(
    modifier: Modifier = Modifier,
    mathCharacter: String = "0",
    mathResult: ArithmeticState = ArithmeticState.Initialize,
) {

    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.surfaceVariant,
        shape = RoundedCornerShape(
            bottomEnd = 18.dp,
            bottomStart = 18.dp,
        )
    ) {
        Column(
            modifier = Modifier.padding(
                vertical = 12.dp,
                horizontal = 16.dp,
            ),
            verticalArrangement = Arrangement.Bottom,
        ) {
            TextMathCharacter(
                modifier = Modifier.padding(vertical = 12.dp),
                style = MaterialTheme.typography.displayLarge.copy(color = MaterialTheme.colorScheme.onSurface),
                textValue = mathCharacter,
                isReadOnly = true,
                onChangeValue = {

                },
            )
            when (mathResult) {
                is ArithmeticState.Result -> {
                    TextMathCharacter(
                        modifier = Modifier.padding(vertical = 12.dp),
                        style = MaterialTheme.typography.displayLarge.copy(color = MaterialTheme.colorScheme.onSurface),
                        textValue = mathResult.result,
                        isReadOnly = true,
                        onChangeValue = {

                        },
                    )
                }

                is ArithmeticState.InvalidArithmetic -> {
                    TextMathCharacter(
                        modifier = Modifier.padding(vertical = 12.dp),
                        style = MaterialTheme.typography.displayLarge.copy(color = MaterialTheme.colorScheme.onSurface),
                        textValue = mathResult.result ?: "",
                        isReadOnly = true,
                        onChangeValue = {

                        },
                    )
                }

                is ArithmeticState.InvalidNumber -> {
                    TextMathCharacter(
                        modifier = Modifier.padding(vertical = 12.dp),
                        style = MaterialTheme.typography.displayLarge.copy(color = MaterialTheme.colorScheme.onSurface),
                        textValue = stringResource(id = R.string.invalid_number),
                        isReadOnly = true,
                        onChangeValue = {

                        },
                    )
                }

                is ArithmeticState.ArithmeticFailure -> {
                    TextMathCharacter(
                        modifier = Modifier.padding(vertical = 12.dp),
                        style = MaterialTheme.typography.displayLarge.copy(color = MaterialTheme.colorScheme.onSurface),
                        textValue = stringResource(id = R.string.failure_number),
                        isReadOnly = true,
                        onChangeValue = {

                        },
                    )
                }

                else -> Unit
            }
        }
    }
}

@Composable
private fun TextMathCharacter(
    modifier: Modifier = Modifier,
    textValue: String,
    style: TextStyle,
    isReadOnly: Boolean = false,
    onChangeValue: (String) -> Unit,
) {

    BasicTextField(
        modifier = modifier.fillMaxWidth(),
        value = textValue,
        readOnly = isReadOnly,
        onValueChange = onChangeValue,
        textStyle = style,
        maxLines = 2,
        enabled = true
    )
}
