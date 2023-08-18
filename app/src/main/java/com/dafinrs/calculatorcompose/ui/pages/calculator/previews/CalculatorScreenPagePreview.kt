package com.dafinrs.calculatorcompose.ui.pages.calculator.previews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import com.dafinrs.calculatorcompose.ui.pages.calculator.components.ButtonsBox
import com.dafinrs.calculatorcompose.ui.pages.calculator.components.TextViewBox
import com.dafinrs.calculatorcompose.ui.theme.CalculatorComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun CalculatorScreenPageReviewLight() {
    CalculatorComposeTheme() {
        Scaffold {
            Column(modifier = Modifier.padding(it)) {
                TextViewBox(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.4f),
                    mathCharacter = "10x10",
                    mathResult = "100"
                )
                ButtonsBox(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1f), onPress7Button = {

                }, onPress8Button = {

                }, onPress9Button = {

                }, onPress0Button = {

                }, onPress1Button = {

                }, onPress2Button = {

                }, onPress3Button = {

                }, onPress4Button = {

                }, onPress5Button = {

                }, onPress6Button = {

                }, onPressReduction = {

                }, onPressMultiplication = {

                }, onPressResult = {

                }, onReset = {

                }, onSetDouble = {

                },
                    onPressDivisionSlash = {},
                    onPressPlusSign = {},
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, apiLevel = 30)
@Composable
fun CalculatorScreenPageReviewDark() {

    CalculatorComposeTheme(darkTheme = true) {
        Scaffold {
            Column(modifier = Modifier.padding(it)) {
                TextViewBox(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.4f),
                    mathCharacter = "10x10",
                    mathResult = "100"
                )
                ButtonsBox(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(1f),
                    onPress7Button = {

                    },
                    onPress8Button = {

                    },
                    onPress9Button = {

                    },
                    onPress0Button = {

                    },
                    onPress1Button = {

                    },
                    onPress2Button = {

                    },
                    onPress3Button = {

                    },
                    onPress4Button = {

                    },
                    onPress5Button = {

                    },
                    onPress6Button = {

                    },
                    onPressReduction = {

                    },
                    onPressMultiplication = {

                    },
                    onPressResult = {

                    },
                    onReset = {

                    },
                    onSetDouble = {

                    },
                    onPressDivisionSlash = {},
                    onPressPlusSign = {},
                )
            }
        }
    }
}