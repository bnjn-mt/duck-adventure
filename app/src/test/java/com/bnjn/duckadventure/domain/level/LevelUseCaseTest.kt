package com.bnjn.duckadventure.domain.level

import com.bnjn.duckadventure.domain.level.models.LevelGrid
import com.bnjn.duckadventure.domain.level.models.Player
import org.junit.Assert.assertTrue
import org.junit.Test
import java.lang.Thread.sleep

class LevelUseCaseTest {
    @Test
    fun `getLevel should return a level containing a single Player object when LevelUseCase is init with a LevelGrid`() {
        val levelUseCase = LevelUseCase(LevelGrid(10, 10))
        levelUseCase.execute()
        assertTrue(levelUseCase.getLevel().flatten().count { it is Player } == 1)
    }

    @Test
    fun `getPlayerPosition should return a valid player position as a pair`() {
        val levelUseCase = LevelUseCase(LevelGrid(10, 10))
        levelUseCase.execute()
        val playerPosition: Pair<Int, Int> = levelUseCase.getPlayerPosition()

        assertTrue(playerPosition.first <= 10)
        assertTrue(playerPosition.second <= 10)
        assertTrue(playerPosition.first >= 0)
        assertTrue(playerPosition.second >= 0)
    }

    @Test
    fun `the Player should start at a random position`() {
        val levelUseCase = LevelUseCase(LevelGrid(100, 100))
        levelUseCase.execute()
        val anotherLevelUseCase = LevelUseCase(LevelGrid(100, 100))
        anotherLevelUseCase.execute()
        assertTrue(levelUseCase.getPlayerPosition().first != anotherLevelUseCase.getPlayerPosition().first)
        assertTrue(levelUseCase.getPlayerPosition().second != anotherLevelUseCase.getPlayerPosition().second)
    }
}
