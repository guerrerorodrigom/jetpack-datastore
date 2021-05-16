package com.rodrigoguerrero.spacedata.data

import java.util.*

data class SpaceMission(
    val name: String,
    val program: SpaceProgram,
    val date: Calendar,
    val crew: String,
    val image: String
)
