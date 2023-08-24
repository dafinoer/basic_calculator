package com.dafinrs.calculatorcompose.ui.pages.calculator


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dafinrs.calculatorcompose.data.repository.ArithmeticRepository
import com.dafinrs.calculatorcompose.domains.model.MathSymbol
import com.dafinrs.calculatorcompose.presentation.arithmetic.ArithmeticViewModel
import com.dafinrs.calculatorcompose.presentation.typing.rememberEditTextState
import com.dafinrs.calculatorcompose.ui.pages.calculator.components.ButtonsBox
import com.dafinrs.calculatorcompose.ui.pages.calculator.components.TextViewBox
import kotlinx.coroutines.Dispatchers
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorScreenPage() {
    val arithmeticRepository =
        koinInject<ArithmeticRepository>(parameters = { parametersOf(Dispatchers.Main) })
    val arithmeticViewModel =
        koinInject<ArithmeticViewModel>(parameters = { parametersOf(arithmeticRepository) })

    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            val editTextState = rememberEditTextState(initialState = "")
            val arithmeticResult =
                arithmeticViewModel.arithmeticUiState.collectAsStateWithLifecycle()

            TextViewBox(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f),
                mathCharacter = editTextState.textState.value,
                mathResult = arithmeticResult.value
            )
            ButtonsBox(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1f),
                onPress7Button = {
                    editTextState.addText("7")
                },
                onPress8Button = {
                    editTextState.addText("8")
                },
                onPress9Button = {
                    editTextState.addText("9")
                },
                onPress0Button = {
                    editTextState.addText("0")
                },
                onPress1Button = {
                    editTextState.addText("1")
                },
                onPress2Button = {
                    editTextState.addText("2")
                },
                onPress3Button = {
                    editTextState.addText("3")
                },
                onPress4Button = {
                    editTextState.addText("4")
                },
                onPress5Button = {
                    editTextState.addText("5")
                },
                onPress6Button = {
                    editTextState.addText("6")
                },
                onPressReduction = {
                    editTextState.addSymbol(MathSymbol.MINUS_SIGN)
                },
                onPressMultiplication = {
                    editTextState.addSymbol(MathSymbol.TIMES_SIGN)
                },
                onPressPlusSign = {
                    editTextState.addSymbol(MathSymbol.PLUS_SIGN)
                },
                onPressDivisionSlash = {
                    editTextState.addSymbol(MathSymbol.DIVISION_SLASH)
                },
                onReset = {
                    editTextState.onReset()
                    arithmeticViewModel.setToIdle()
                },
                onSetDouble = {
                    editTextState.onAddDouble()
                },
                onOpenBracket = {

                },
                onCloseBracket = {

                },
                onPressResult = {
                    if (editTextState.isValidateCalculate()) {
                        arithmeticViewModel.calculate(editTextState.textState.value)
                    }
                },
            )
        }
    }
}