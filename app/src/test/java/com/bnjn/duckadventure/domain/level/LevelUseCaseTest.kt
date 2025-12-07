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
        val playerStartPosition: Pair<Int, Int> = levelUseCase.getPlayerStartPosition()

        assertTrue(playerStartPosition.first <= 10)
        assertTrue(playerStartPosition.second <= 10)
        assertTrue(playerStartPosition.first >= 0)
        assertTrue(playerStartPosition.second >= 0)
    }

    @Test
    fun `the Player should start at a random position`() {
        val levelUseCase = LevelUseCase(LevelGrid(1000, 1000))
        val anotherLevelUseCase = LevelUseCase(LevelGrid(1000, 1000))

        assertTrue(levelUseCase.getPlayerStartPosition().first != anotherLevelUseCase.getPlayerStartPosition().first)
        assertTrue(levelUseCase.getPlayerStartPosition().second != anotherLevelUseCase.getPlayerStartPosition().second)
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
        assertTrue(levelUseCase.getPlayerStartPosition().first == 1)
        assertTrue(levelUseCase.getPlayerStartPosition().second == 1)
    }
}
