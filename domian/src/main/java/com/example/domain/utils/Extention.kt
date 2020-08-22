package com.example.domain.utils

import com.example.entity.responcemodel.SpecialtyDb
import com.example.entity.responcemodel.WorkersInfoDb

fun initUserData(): List<WorkersInfoDb> {
    val worker1 = WorkersInfoDb(
        0,
        "иВан",
        "ИваноВ",
        "1987-03-23",
        "https://2.cdn.echo.msk.ru/files/avatar2/2561900.jpg",
        listOf(SpecialtyDb(101, "Менеджер"))
    )
    val worker2 = WorkersInfoDb(
        1,
        "Петр",
        "петроВ",
        null,
        "https://2.cdn.echo.msk.ru/files/avatar2/1253126.jpg",
        listOf(SpecialtyDb(101, "Менеджер"))
    )
    val worker3 = WorkersInfoDb(
        2,
        "Вася",
        "Пупкин",
        "1985-11-29",
        "https://2.cdn.echo.msk.ru/files/avatar2/1450682.jpg",
        listOf(SpecialtyDb(101, "Менеджер"), SpecialtyDb(102, "Разработчик"))
    )
    val worker4 = WorkersInfoDb(
        3,
        "ЕКАТЕРИНА",
        "пертрова",
        "1990-01-07",
        "https://2.cdn.echo.msk.ru/files/avatar2/1450682.jpg",
        listOf(SpecialtyDb(102, "Разработчик"))
    )
    val worker5 =
        WorkersInfoDb(4, "Николай", "Сидоров", "", null, listOf(SpecialtyDb(102, "Разработчик")))
    val worker6 = WorkersInfoDb(
        5,
        "Виктор",
        "Федотов",
        "23-07-2000",
        "https://2.cdn.echo.msk.ru/files/avatar2/2441412.jpg",
        listOf(SpecialtyDb(102, "Разработчик"))
    )
    val worker7 = WorkersInfoDb(
        6,
        "Артур",
        "ВАрламов",
        "23-07-2000",
        "https://2.cdn.echo.msk.ru/files/avatar2/808879.jpg",
        listOf(SpecialtyDb(102, "Разработчик"))
    )
    val worker8 = WorkersInfoDb(
        7,
        "Артур",
        "ВАрламов",
        "23-07-1982",
        "https://2.cdn.echo.msk.ru/files/avatar2/2933492.jpg",
        listOf(SpecialtyDb(102, "Разработчик"))
    )
    val worker9 = WorkersInfoDb(
        8,
        "Руслан",
        "Русанов",
        "17-10-1984",
        "https://2.cdn.echo.msk.ru/files/avatar2/844319.jpg",
        listOf(SpecialtyDb(102, "Разработчик"))
    )
    val worker10 = WorkersInfoDb(
        9,
        "Владимир",
        "Миронов",
        "03-08-1972",
        "https://2.cdn.echo.msk.ru/files/avatar2/3073407.jpg",
        listOf(SpecialtyDb(102, "Разработчик"))
    )



    return mutableListOf(
        worker1,
        worker2,
        worker3,
        worker4,
        worker5,
        worker6,
        worker7,
        worker8,
        worker9,
        worker10
    )
}