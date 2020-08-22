package com.example.data.di

import android.app.Application
import androidx.room.Room
import com.example.data.dataservice.sqlservice.AppDatabase
import com.example.data.datastore.LocalSQLRepository
import com.example.data.datastore.WorkersRepository
import com.example.data.repository.LocalSQLRepositoryImpl
import com.example.data.repository.WorkersRepositoryImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "WorkersDB")
            .allowMainThreadQueries()
            .build()
    }
    single { provideDatabase(androidApplication()).workersDao() }

}

val repositoryModule = module {
    single<WorkersRepository> { WorkersRepositoryImpl(get()) }
    single<LocalSQLRepository> { LocalSQLRepositoryImpl(get()) }
}