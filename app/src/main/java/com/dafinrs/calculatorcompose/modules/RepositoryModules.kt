package com.dafinrs.calculatorcompose.modules

import com.dafinrs.calculatorcompose.repository.CalculatorRepository
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.InjectedParam
import org.koin.core.annotation.Module


@Module
class RepositoryModules {

    @Factory
    fun bindCalculator() =
        CalculatorRepository()
}