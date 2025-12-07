package com.bnjn.duckadventure.domain.level

import com.bnjn.duckadventure.domain.level.models.LevelGrid
import com.bnjn.duckadventure.domain.level.models.Player
import com.bnjn.duckadventure.domain.level.models.Wall
import kotlin.random.Random

class LevelUseCase(
    levelGrid: LevelGrid,
) {
    private var level: Array<Array<Any?>> = levelGrid.grid
    private var playerPosition: Pair<Int, Int> = Pair(Random.nextInt(1, level.size - 1), Random.nextInt(1, level[0].size - 1))

    init {
        // Set up perimeter Walls
        level.first().forEachIndexed { index, row -> level.first()[index] = Wall() }
        level.last().forEachIndexed { index, row -> level.last()[index] = Wall() }
        level.forEachIndexed { index, row ->
            if (index != 0 && index != level.lastIndex) {
                row[0] = Wall()
                row[row.lastIndex] = Wall()
            }
        }

        // Set up level with a Player
        level[playerPosition.first][playerPosition.second] = Player()
    }

    fun getLevel(): Array<Array<Any?>> = level

    fun getPlayerPosition(): Pair<Int, Int> = playerPosition
}
