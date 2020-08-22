package com.example.testapplication.di

import com.example.testapplication.fragment.workers.viewmodel.WorkersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { WorkersViewModel(get()) }
}
