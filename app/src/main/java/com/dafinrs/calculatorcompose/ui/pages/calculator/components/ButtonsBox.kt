package com.dafinrs.calculatorcompose.ui.pages.calculator.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dafinrs.calculatorcompose.R
import com.dafinrs.calculatorcompose.ui.pages.calculator.ButtonCalculator


@Composable
fun ButtonsBox(
    modifier: Modifier = Modifier,
    disableAddDouble: Boolean = false,
    onReset: () -> Unit,
    onPress7Button: () -> Unit,
    onPress8Button: () -> Unit,
    onPress9Button: () -> Unit,
    onPress4Button: () -> Unit,
    onPress5Button: () -> Unit,
    onPress6Button: () -> Unit,
    onPress1Button: () -> Unit,
    onPress2Button: () -> Unit,
    onPress3Button: () -> Unit,
    onPress0Button: () -> Unit,
    onSetDouble: () -> Unit,
    onPressReduction: () -> Unit,
    onPressMultiplication: () -> Unit,
    onPressPlusSign: () -> Unit,
    onPressDivisionSlash: () -> Unit,
    onOpenBracket: () -> Unit,
    onCloseBracket: () -> Unit,
    onPressResult: () -> Unit,
) {

    BoxWithConstraints(modifier = modifier) {
        val sizeWidthButton = remember {
            derivedStateOf {
                (this.maxWidth.value / 5).minus(4)
            }
        }

        Surface(modifier = modifier) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 8.dp),
                verticalArrangement = Arrangement.Center
            ) {
                RowBox {
                    ButtonCalculator(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        onTap = onReset,
                        sizeHeight = sizeWidthButton.value.dp,
                        sizeWidth = sizeWidthButton.value.dp,
                        color = MaterialTheme.colorScheme.onSurface
                    ) {
                        Text(
                            text = "AC",
                            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.surface,
                        )
                    }
                    ButtonCalculator(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        onTap = onOpenBracket,
                        sizeHeight = sizeWidthButton.value.dp,
                        sizeWidth = sizeWidthButton.value.dp,
                        color = MaterialTheme.colorScheme.onSurface
                    ) {
                        Text(
                            text = "(",
                            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.surface,
                        )
                    }
                    ButtonCalculator(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        onTap = onCloseBracket,
                        sizeHeight = sizeWidthButton.value.dp,
                        sizeWidth = sizeWidthButton.value.dp,
                        color = MaterialTheme.colorScheme.onSurface
                    ) {
                        Text(
                            text = ")",
                            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.surface,
                        )
                    }
                    ButtonCalculator(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        onTap = onPressDivisionSlash,
                        sizeHeight = sizeWidthButton.value.dp,
                        sizeWidth = sizeWidthButton.value.dp,
                        color = MaterialTheme.colorScheme.onSurface
                    ) {
                        Text(
                            text = "/",
                            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.surface,
                        )
                    }
                }
                RowBox {
                    ButtonCalculator(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        onTap = onPress7Button,
                        sizeHeight = sizeWidthButton.value.dp,
                        sizeWidth = sizeWidthButton.value.dp,
                        color = MaterialTheme.colorScheme.onSurface
                    ) {
                        Text(
                            text = "7",
                            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.surface,
                        )
                    }
                    ButtonCalculator(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        onTap = onPress8Button,
                        sizeHeight = sizeWidthButton.value.dp,
                        sizeWidth = sizeWidthButton.value.dp,
                        color = MaterialTheme.colorScheme.onSurface
                    ) {
                        Text(
                            text = "8",
                            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.surface,
                        )
                    }
                    ButtonCalculator(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        onTap = onPress9Button,
                        sizeHeight = sizeWidthButton.value.dp,
                        sizeWidth = sizeWidthButton.value.dp,
                        color = MaterialTheme.colorScheme.onSurface
                    ) {
                        Text(
                            text = "9",
                            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.surface,
                        )
                    }
                    ButtonCalculator(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        onTap = onPressMultiplication,
                        sizeHeight = sizeWidthButton.value.dp,
                        sizeWidth = sizeWidthButton.value.dp,
                        color = MaterialTheme.colorScheme.onSurface
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = stringResource(
                                id = R.string.multiplication
                            ),
                            tint = MaterialTheme.colorScheme.surface,
                        )
                    }
                }
                RowBox {
                    ButtonCalculator(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        onTap = onPress4Button,
                        sizeHeight = sizeWidthButton.value.dp,
                        sizeWidth = sizeWidthButton.value.dp,
                        color = MaterialTheme.colorScheme.onSurface
                    ) {
                        Text(
                            text = "4",
                            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.surface,
                        )
                    }
                    ButtonCalculator(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        onTap = onPress5Button,
                        sizeHeight = sizeWidthButton.value.dp,
                        sizeWidth = sizeWidthButton.value.dp,
                        color = MaterialTheme.colorScheme.onSurface
                    ) {
                        Text(
                            text = "5",
                            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.surface,
                        )
                    }
                    ButtonCalculator(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        onTap = onPress6Button,
                        sizeHeight = sizeWidthButton.value.dp,
                        sizeWidth = sizeWidthButton.value.dp,
                        color = MaterialTheme.colorScheme.onSurface
                    ) {
                        Text(
                            text = "6",
                            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.surface,
                        )
                    }
                    ButtonCalculator(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        onTap = onPressReduction,
                        sizeHeight = sizeWidthButton.value.dp,
                        sizeWidth = sizeWidthButton.value.dp,
                        color = MaterialTheme.colorScheme.onSurface
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.baseline_remove_24),
                            contentDescription = stringResource(id = R.string.reduction_sign),
                            tint = MaterialTheme.colorScheme.surface
                        )
                    }
                }
                RowBox {
                    ButtonCalculator(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        onTap = onPress1Button,
                        sizeHeight = sizeWidthButton.value.dp,
                        sizeWidth = sizeWidthButton.value.dp,
                        color = MaterialTheme.colorScheme.onSurface
                    ) {
                        Text(
                            text = "1",
                            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.surface,
                        )
                    }
                    ButtonCalculator(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        onTap = onPress2Button,
                        sizeHeight = sizeWidthButton.value.dp,
                        sizeWidth = sizeWidthButton.value.dp,
                        color = MaterialTheme.colorScheme.onSurface
                    ) {
                        Text(
                            text = "2",
                            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.surface,
                        )
                    }
                    ButtonCalculator(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        onTap = onPress3Button,
                        sizeHeight = sizeWidthButton.value.dp,
                        sizeWidth = sizeWidthButton.value.dp,
                        color = MaterialTheme.colorScheme.onSurface
                    ) {
                        Text(
                            text = "3",
                            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.surface,
                        )
                    }
                    ButtonCalculator(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        onTap = onPressPlusSign,
                        sizeHeight = sizeWidthButton.value.dp,
                        sizeWidth = sizeWidthButton.value.dp,
                        color = MaterialTheme.colorScheme.onSurface
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = stringResource(id = R.string.plus_sign),
                            tint = MaterialTheme.colorScheme.surface,
                        )
                    }
                }
                RowBox {
                    ButtonCalculator(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        onTap = { /*TODO*/ },
                        sizeHeight = sizeWidthButton.value.dp,
                        sizeWidth = sizeWidthButton.value.dp,
                        color = MaterialTheme.colorScheme.onSurface
                    ) {

                    }
                    ButtonCalculator(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        onTap = onPress0Button,
                        sizeHeight = sizeWidthButton.value.dp,
                        sizeWidth = sizeWidthButton.value.dp,
                        color = MaterialTheme.colorScheme.onSurface
                    ) {
                        Text(
                            text = "0",
                            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.surface,
                        )
                    }
                    ButtonCalculator(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        onTap = onSetDouble,
                        sizeHeight = sizeWidthButton.value.dp,
                        sizeWidth = sizeWidthButton.value.dp,
                        color = MaterialTheme.colorScheme.onSurface,
                        disableButton = disableAddDouble,
                    ) {
                        Text(
                            text = ".",
                            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.surface,
                        )
                    }
                    ButtonCalculator(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        onTap = onPressResult,
                        sizeHeight = sizeWidthButton.value.dp,
                        sizeWidth = sizeWidthButton.value.dp,
                        color = MaterialTheme.colorScheme.primaryContainer
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.equal_48px),
                            contentDescription = stringResource(id = R.string.equal_sign),
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun RowBox(modifier: Modifier = Modifier, rowScope: @Composable RowScope.() -> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        content = rowScope,
        horizontalArrangement = Arrangement.Center
    )
}