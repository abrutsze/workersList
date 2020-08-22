package com.example.data.datastore

import com.example.entity.responcemodel.WorkersInfoDb

interface LocalSQLRepository {
    suspend fun addWorkersListDB(item: WorkersInfoDb)
    fun getWorkersListDB(): List<WorkersInfoDb>
}