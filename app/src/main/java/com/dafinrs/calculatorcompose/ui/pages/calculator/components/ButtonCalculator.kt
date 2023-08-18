package com.dafinrs.calculatorcompose.ui.pages.calculator

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dafinrs.calculatorcompose.ui.theme.CalculatorComposeTheme


@Composable
fun ButtonCalculator(
    modifier: Modifier = Modifier,
    onTap: () -> Unit,
    sizeHeight: Dp,
    sizeWidth: Dp,
    color: Color,
    disableButton: Boolean = false,
    child: @Composable RowScope.() -> Unit,
) {
    OutlinedButton(
        modifier = modifier.size(height = sizeHeight, width = sizeWidth),
        onClick = onTap,
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
        ),
        shape = CircleShape,
        contentPadding = PaddingValues(0.dp),
        border = BorderStroke(0.dp, color),
        enabled = !disableButton,
        content = child,
    )
}


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