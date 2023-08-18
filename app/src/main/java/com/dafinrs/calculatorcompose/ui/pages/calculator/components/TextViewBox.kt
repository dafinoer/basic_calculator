package com.dafinrs.calculatorcompose.ui.pages.calculator.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TextViewBox(
    modifier: Modifier = Modifier,
    mathCharacter: String = "0",
    mathResult: String? = null,
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
            TextMathCharacter(
                modifier = Modifier.padding(vertical = 12.dp),
                style = MaterialTheme.typography.displayLarge.copy(color = MaterialTheme.colorScheme.onSurface),
                textValue = mathResult ?: "",
                isReadOnly = true,
                onChangeValue = {

                },
            )
        }
    }
}

@Composable
private fun TextMathCharacter(
    modifier: Modifier = Modifier,
    isReadOnly: Boolean = false,
    style: TextStyle,
    textValue: String,
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
