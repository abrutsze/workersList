package com.example.data.repository

import com.example.data.dataservice.sqlservice.WorkersInfoDto
import com.example.data.datastore.LocalSQLRepository
import com.example.entity.responcemodel.WorkersInfoDb

class LocalSQLRepositoryImpl(
    private val workersInfoDao: WorkersInfoDto
) : LocalSQLRepository {
    override suspend fun addWorkersListDB(item: WorkersInfoDb) =
        workersInfoDao.insertDefaultData(item)

    override fun getWorkersListDB(): List<WorkersInfoDb> = workersInfoDao.getWorkersList()
}