package com.bnjn.duckadventure.domain.level.models

import kotlin.arrayOfNulls

data class LevelGrid(
    private val height: Int,
    private val width: Int,
) {
    val grid = Array<Array<Any?>>(height) { arrayOfNulls<Any?>(width) }
}
