package com.dafinrs.calculatorcompose.ui.pages.calculator


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dafinrs.calculatorcompose.model.MathSymbol
import com.dafinrs.calculatorcompose.presentation.typing.MathStateResult
import com.dafinrs.calculatorcompose.presentation.typing.rememberEditTextState
import com.dafinrs.calculatorcompose.repository.CalculatorRepository
import com.dafinrs.calculatorcompose.ui.pages.calculator.components.ButtonsBox
import com.dafinrs.calculatorcompose.ui.pages.calculator.components.TextViewBox
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorScreenPage() {
    val calculatorRepository =
        koinInject<CalculatorRepository>()

    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            val editTextState = rememberEditTextState(initialState = "", calculatorRepository)

            TextViewBox(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f),
                mathCharacter = editTextState.textState.value,
                mathResult = editTextState.resultState.value
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
                    editTextState.addSymbol(MathSymbol.KURANG)
                },
                onPressMultiplication = {
                    editTextState.addSymbol(MathSymbol.KALI)
                },
                onPressPlusSign = {
                    editTextState.addSymbol(MathSymbol.TAMBAH)
                },
                onPressDivisionSlash = {
                    editTextState.addSymbol(MathSymbol.BAGI)
                },
                onPressResult = {
                    editTextState.onResult()
                },
                onReset = {
                    editTextState.onReset()
                },
                onSetDouble = {
                    editTextState.onAddDouble()
                },
            )
        }
    }
}