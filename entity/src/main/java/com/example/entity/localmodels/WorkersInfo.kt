package com.example.entity.localmodels

import android.os.Parcel
import android.os.Parcelable
import com.example.entity.responcemodel.SpecialtyDb

data class WorkersInfo(
    var firstName: String? = "",
    var lastName: String? = "",
    var birthday: String? = "",
    var avatarUrl: String? = "",
    var specialtyDb: List<SpecialtyDb>? = mutableListOf(),
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createTypedArrayList(SpecialtyDb)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(birthday)
        parcel.writeString(avatarUrl)
        parcel.writeTypedList(specialtyDb)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WorkersInfo> {
        override fun createFromParcel(parcel: Parcel): WorkersInfo {
            return WorkersInfo(parcel)
        }

        override fun newArray(size: Int): Array<WorkersInfo?> {
            return arrayOfNulls(size)
        }
    }
}