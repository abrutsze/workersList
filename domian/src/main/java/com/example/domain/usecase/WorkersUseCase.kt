package com.example.domain.usecase


import com.example.data.datastore.WorkersRepository
import com.example.domain.interactors.WorkersInteractor
import com.example.domain.utils.initUserData
import com.example.domain.utils.toLocalStation
import com.example.entity.localmodels.WorkersInfo
import com.example.entity.responcemodel.WorkersInfoDb
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.channelFlow

class WorkersUseCase(private val workersRepository: WorkersRepository) :
    WorkersInteractor {
    @Suppress("EXPERIMENTAL_API_USAGE")
    override suspend fun getWorkersDataLocalDB() = channelFlow<List<WorkersInfo>> {
        val workersListDb: List<WorkersInfoDb>? = workersRepository.getWorkersListLocalDB()
        val workersList: MutableList<WorkersInfo> = mutableListOf()
        workersListDb?.let {

            if (it.isNotEmpty()) {
                for (mappingItem in it)
                    workersList.add(mappingItem.toLocalStation())
                channel.offer(workersList)
            } else {
                val defaultData = initUserData()
                defaultData.apply {
                    forEach {
                        workersRepository.addWorkersListDB(it)
                        workersList.add(it.toLocalStation())
                    }
                }
                channel.offer(workersList)
            }

        } ?: initDefaultData(channel, workersList)
        awaitClose {}
    }

    private suspend fun initDefaultData(
        channel: SendChannel<List<WorkersInfo>>,
        workersList: MutableList<WorkersInfo>
    ) {
        val defaultData = initUserData()
        for (mappingItem in defaultData)
            workersList.add(mappingItem.toLocalStation())
        defaultData.apply {
            forEach {
                workersRepository.addWorkersListDB(it)
            }
        }
        channel.offer(workersList)

    }

}