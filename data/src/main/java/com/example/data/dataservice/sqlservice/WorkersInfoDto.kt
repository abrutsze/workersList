package com.example.data.dataservice.sqlservice

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.entity.responcemodel.WorkersInfoDb

@Dao
interface WorkersInfoDto {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDefaultData(item: WorkersInfoDb)

    @Query("SELECT * FROM userdata")
    fun getWorkersList(): List<WorkersInfoDb>

}