package com.example.data.dataservice.sqlservice

import androidx.room.TypeConverter
import com.example.entity.responcemodel.SpecialtyDb
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.Type

class Converters {
    @TypeConverter
    fun fromSpecialtyDbData(json: String): List<SpecialtyDb>? {
        val listMyData: Type =
            Types.newParameterizedType(MutableList::class.java, SpecialtyDb::class.java)
        val adapter: JsonAdapter<List<SpecialtyDb>> = Moshi.Builder().build().adapter(listMyData)
        return adapter.fromJson(json);
    }

    @TypeConverter
    fun fromSpecialtyDbData(images: List<SpecialtyDb>): String {
        val listMyData: Type =
            Types.newParameterizedType(MutableList::class.java, SpecialtyDb::class.java)
        val jsonAdapter: JsonAdapter<List<SpecialtyDb>> =
            Moshi.Builder().build().adapter(listMyData)
        return jsonAdapter.toJson(images)
    }

}