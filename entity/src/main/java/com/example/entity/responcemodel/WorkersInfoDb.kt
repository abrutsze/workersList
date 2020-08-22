package com.example.entity.responcemodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userdata")
data class WorkersInfoDb(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "f_name")
    var f_name: String? = "",
    @ColumnInfo(name = "l_name")
    var l_name: String? = "",
    @ColumnInfo(name = "birthday")
    var birthday: String? = "",
    @ColumnInfo(name = "avatr_url")
    var avatr_url: String? = "",
    @ColumnInfo(name = "specialty")
    var specialty: List<SpecialtyDb>? = mutableListOf(),
)