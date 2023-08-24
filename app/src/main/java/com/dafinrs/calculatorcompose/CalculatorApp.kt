package com.dafinrs.calculatorcompose

import android.app.Application
import com.dafinrs.calculatorcompose.modules.RepositoryModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.ksp.generated.defaultModule
import org.koin.ksp.generated.module


class CalculatorApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@CalculatorApp)
            modules(
                defaultModule,
                RepositoryModules().module
            )
        }
    }
}