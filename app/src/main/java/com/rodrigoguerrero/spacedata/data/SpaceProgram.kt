package com.rodrigoguerrero.spacedata.data

sealed class SpaceProgram {
    object Mercury : SpaceProgram()
    object Gemini : SpaceProgram()
    object Apollo : SpaceProgram()
    object Shuttle : SpaceProgram()
}
