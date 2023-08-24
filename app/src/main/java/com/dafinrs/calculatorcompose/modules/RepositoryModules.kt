package com.dafinrs.calculatorcompose.modules

import com.dafinrs.calculatorcompose.data.repository.ArithmeticRepository
import com.dafinrs.calculatorcompose.domains.repository.ArithmeticRepositoryImpl
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module


@Module
class RepositoryModules {

    @Factory(binds = [ArithmeticRepository::class])
    fun bindCalculatorRepository(coroutineDispatcher: CoroutineDispatcher) =
        ArithmeticRepositoryImpl(coroutineDispatcher)
}