package com.example.testapplication.fragment.workers.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.WorkersInteractor
import com.example.entity.localmodels.WorkersInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WorkersViewModel(private val workersInteractor: WorkersInteractor) :
    ViewModel() {
    private val _getWorkersListDataDb: MutableLiveData<List<WorkersInfo>> by lazy { MutableLiveData<List<WorkersInfo>>() }
    val getWorkersListDataDb: LiveData<List<WorkersInfo>> = _getWorkersListDataDb

    init {
        getWorkersList()
    }

    private fun getWorkersList() {
        viewModelScope.launch(Dispatchers.Unconfined) {
            withContext(Dispatchers.Main) {
                workersInteractor.getWorkersDataLocalDB().collect {
                    _getWorkersListDataDb.value = it
                }
            }
        }
    }


}