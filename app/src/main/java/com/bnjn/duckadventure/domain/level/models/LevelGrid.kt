package com.bnjn.duckadventure.domain.level.models

import kotlin.arrayOfNulls

data class LevelGrid(
    private val height: Int,
    private val width: Int,
) {
    init {
        if (height < 1 && width < 1) throw IllegalArgumentException("Height and width must be greater than 0!")
        if (height < 1) throw IllegalArgumentException("Height must be greater than 0!")
        if (width < 1) throw IllegalArgumentException("Width must be greater than 0!")
    }

    val grid = Array<Array<Any?>>(height) { arrayOfNulls<Any?>(width) }
}
