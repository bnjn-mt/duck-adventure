package com.bnjn.duckadventure.domain.level

import org.junit.Test
import org.junit.Assert.*

class LevelUseCaseTest {
    @Test
    fun `returns a 2D list`() {
        val levelUseCase = LevelUseCase()
        val result = levelUseCase.execute()

        assertTrue(result is List<List<*>>)
    }
}