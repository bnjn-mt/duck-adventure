package com.bnjn.duckadventure.domain.level

import com.bnjn.duckadventure.domain.level.models.LevelGrid
import com.bnjn.duckadventure.domain.level.models.Player
import com.bnjn.duckadventure.domain.level.models.Wall
import org.junit.Assert.assertTrue
import org.junit.Test

class LevelUseCaseTest {
    @Test
    fun `getLevel should return a level containing a single Player object when LevelUseCase is init with a LevelGrid`() {
        val levelUseCase = LevelUseCase(LevelGrid(10, 10))
        assertTrue(levelUseCase.getLevel().flatten().count { it is Player } == 1)
    }

    @Test
    fun `getPlayerPosition should return a valid player position as a pair`() {
        val levelUseCase = LevelUseCase(LevelGrid(10, 10))
        val playerPosition: Pair<Int, Int> = levelUseCase.getPlayerPosition()

        assertTrue(playerPosition.first <= 10)
        assertTrue(playerPosition.second <= 10)
        assertTrue(playerPosition.first >= 0)
        assertTrue(playerPosition.second >= 0)
    }

    @Test
    fun `the Player should start at a random position`() {
        val levelUseCase = LevelUseCase(LevelGrid(1000, 1000))
        val anotherLevelUseCase = LevelUseCase(LevelGrid(1000, 1000))

        assertTrue(levelUseCase.getPlayerPosition().first != anotherLevelUseCase.getPlayerPosition().first)
        assertTrue(levelUseCase.getPlayerPosition().second != anotherLevelUseCase.getPlayerPosition().second)
    }

    @Test
    fun `the LevelGrid should have a Wall at each perimeter position`() {
        val levelUseCase = LevelUseCase(LevelGrid(20, 20))
        val level = levelUseCase.getLevel()

        assertTrue(level.first().all { it is Wall })
        assertTrue(level.last().all { it is Wall })
        assertTrue(level.map { it.first() }.all { it is Wall })
        assertTrue(level.map { it.last() }.all { it is Wall })
    }

    @Test
    fun `a Player can't start where a Wall should be`() {
        val levelUseCase = LevelUseCase(LevelGrid(3, 3))
        val level = levelUseCase.getLevel()

        assertTrue(level.first().all { it is Wall })
        assertTrue(level.last().all { it is Wall })
        assertTrue(level.map { it.first() }.all { it is Wall })
        assertTrue(level.map { it.last() }.all { it is Wall })
        assertTrue(levelUseCase.getPlayerPosition().first == 1)
        assertTrue(levelUseCase.getPlayerPosition().second == 1)
    }
}
