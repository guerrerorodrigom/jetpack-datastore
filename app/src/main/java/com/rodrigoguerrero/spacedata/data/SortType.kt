package com.rodrigoguerrero.spacedata.data

sealed class SortType {
    object Name : SortType()
    object Year : SortType()
}
