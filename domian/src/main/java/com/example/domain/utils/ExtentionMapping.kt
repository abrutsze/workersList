package com.example.domain.utils

import com.example.entity.localmodels.WorkersInfo
import com.example.entity.responcemodel.WorkersInfoDb

fun WorkersInfoDb.toLocalStation() = WorkersInfo(
    firstName = f_name,
    lastName = l_name,
    birthday = birthday,
    avatarUrl = avatr_url,
    specialtyDb = specialty,
)



