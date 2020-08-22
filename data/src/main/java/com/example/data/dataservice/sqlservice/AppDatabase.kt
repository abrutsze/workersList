package com.example.data.dataservice.sqlservice

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.entity.responcemodel.WorkersInfoDb

@Database(
    entities = [WorkersInfoDb::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun workersDao(): WorkersInfoDto
}