package com.example.domain.interactors

import com.example.entity.localmodels.WorkersInfo
import kotlinx.coroutines.flow.Flow

interface WorkersInteractor {
    suspend fun getWorkersDataLocalDB(): Flow<List<WorkersInfo>>
}