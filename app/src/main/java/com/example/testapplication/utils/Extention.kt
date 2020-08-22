package com.example.testapplication.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun calculateAge(birthDate: String?): Int {

    val dateFormat1 = "yyyy-MM-dd"
    val dateFormat2 = "dd-MM-yyyy"

    return if (!birthDate.isNullOrBlank()) {
        val format: SimpleDateFormat = if (validDateFormat(dateFormat1, birthDate)) {
            SimpleDateFormat(dateFormat1)
        } else {
            SimpleDateFormat(dateFormat2)
        }

        var userDate: Date? = null
        try {
            userDate = format.parse(birthDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        val birth = Calendar.getInstance()
        birth.time = userDate
        val today = Calendar.getInstance()
        var yearDifference = (today[Calendar.YEAR]
                - birth[Calendar.YEAR])
        if (today[Calendar.MONTH] < birth[Calendar.MONTH]) {
            yearDifference--
        } else {
            if (today[Calendar.MONTH] == birth[Calendar.MONTH]
                && today[Calendar.DAY_OF_MONTH] < birth[Calendar.DAY_OF_MONTH]
            ) {
                yearDifference--
            }
        }
        yearDifference
    } else {
        0
    }
}

fun convertDateFormat(date: String): String {

    val dateFormat1 = "yyyy-MM-dd"
    val dateFormat2 = "dd-MM-yyyy"
    val dateFormat3 = "dd.MM.yyyy"

    return if (validDateFormat(dateFormat1, date)) {
        var spf = SimpleDateFormat(dateFormat1)
        val newDate = spf.parse(date)
        spf = SimpleDateFormat(dateFormat3)
        spf.format(newDate)
    } else {
        return if (!date.isNullOrBlank()) {
            var spf = SimpleDateFormat(dateFormat2)
            val newDate = spf.parse(date)
            spf = SimpleDateFormat(dateFormat3)
            spf.format(newDate)
        } else {
            ""
        }
    }
}

private fun validDateFormat(format: String, value: String): Boolean {
    return if (!value.isNullOrBlank()) {
        var date: Date? = null
        try {
            val sdf = SimpleDateFormat(format)
            date = sdf.parse(value)
            if (value != sdf.format(date)) {
                date = null
            }
        } catch (ex: ParseException) {
            ex.printStackTrace()
        }
        date != null
    } else {
        false
    }

}