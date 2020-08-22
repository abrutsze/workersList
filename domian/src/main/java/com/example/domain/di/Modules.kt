package com.example.domain.di

import com.example.domain.interactors.WorkersInteractor
import com.example.domain.usecase.WorkersUseCase
import org.koin.dsl.module

val interactorModule = module {
    single<WorkersInteractor> { WorkersUseCase(get()) }
}