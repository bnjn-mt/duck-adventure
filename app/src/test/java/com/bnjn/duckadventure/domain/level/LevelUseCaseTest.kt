package com.bnjn.duckadventure.domain.level

import com.bnjn.duckadventure.domain.level.models.LevelGrid
import com.bnjn.duckadventure.domain.level.models.Player
import org.junit.Assert.assertTrue
import org.junit.Test

class LevelUseCaseTest {
    @Test
    fun `getLevel should return a level containing a single Player object when LevelUseCase is created with a LevelGrid`() {
        val levelUseCase = LevelUseCase(LevelGrid(10, 10))
        levelUseCase.execute()
        assertTrue(levelUseCase.getLevel().flatten().count { it is Player } == 1)
    }
}
