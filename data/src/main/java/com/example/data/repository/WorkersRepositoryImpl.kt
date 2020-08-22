package com.example.data.repository

import com.example.data.datastore.LocalSQLRepository
import com.example.data.datastore.WorkersRepository
import com.example.entity.responcemodel.WorkersInfoDb

class WorkersRepositoryImpl(private val localSql: LocalSQLRepository) :
    WorkersRepository {

    override suspend fun addWorkersListDB(item: WorkersInfoDb) {
        localSql.addWorkersListDB(item)
    }

    override suspend fun getWorkersListLocalDB(): List<WorkersInfoDb> =
        localSql.getWorkersListDB()
}