package com.example.data.datastore

import com.example.entity.responcemodel.WorkersInfoDb

interface WorkersRepository {
    suspend fun addWorkersListDB(item: WorkersInfoDb)
    suspend fun getWorkersListLocalDB(): List<WorkersInfoDb>
}