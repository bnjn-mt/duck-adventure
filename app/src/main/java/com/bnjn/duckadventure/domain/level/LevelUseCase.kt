package com.bnjn.duckadventure.domain.level

import com.bnjn.duckadventure.domain.level.models.LevelGrid
import com.bnjn.duckadventure.domain.level.models.Player

class LevelUseCase(
    levelGrid: LevelGrid,
) {
    private var level: Array<Array<Any?>> = levelGrid.grid

    fun execute() {
        // Set up level with a Player
        level[0][0] = Player()
    }

    fun getLevel(): Array<Array<Any?>> = level
}
