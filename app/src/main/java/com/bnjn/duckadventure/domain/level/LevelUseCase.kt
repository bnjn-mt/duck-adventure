package com.bnjn.duckadventure.domain.level

import com.bnjn.duckadventure.domain.level.models.LevelGrid
import com.bnjn.duckadventure.domain.level.models.Player
import kotlin.random.Random

class LevelUseCase(
    levelGrid: LevelGrid,
) {
    private var level: Array<Array<Any?>> = levelGrid.grid
    private var playerPosition: Pair<Int, Int> = Pair(Random.nextInt(0, level.size), Random.nextInt(0, level[0].size))

    fun execute() {
        // Set up level with a Player
        level[playerPosition.first][playerPosition.second] = Player()
    }

    fun getLevel(): Array<Array<Any?>> = level

    fun getPlayerPosition(): Pair<Int, Int> = playerPosition
}
