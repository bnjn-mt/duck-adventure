package com.bnjn.duckadventure.domain.level.models

data class LevelGrid(
    private val height: Int,
    private val width: Int,
) {
    val grid = Array<Array<*>>(height) { Array<Int>(width) { 0 } }
}