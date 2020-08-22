package com.example.testapplication.app

import android.app.Application
import com.example.data.di.databaseModule

import com.example.data.di.repositoryModule
import com.example.domain.di.interactorModule
import com.example.testapplication.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ApplicationClass)
            modules(modules)
        }
    }

    val modules = listOf(
        databaseModule,
        interactorModule,
        repositoryModule,
        viewModelModule
    )
}