package com.example.entity.responcemodel

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo

class SpecialtyDb(
    @ColumnInfo(name = "specialty_id")
    val specialty_id: Int?,
    @ColumnInfo(name = "name")
    val name: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(specialty_id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SpecialtyDb> {
        override fun createFromParcel(parcel: Parcel): SpecialtyDb {
            return SpecialtyDb(parcel)
        }

        override fun newArray(size: Int): Array<SpecialtyDb?> {
            return arrayOfNulls(size)
        }
    }
}