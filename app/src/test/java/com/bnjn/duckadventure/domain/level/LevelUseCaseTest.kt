package com.bnjn.duckadventure.domain.level

import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Test
import org.junit.Assert.*

class LevelUseCaseTest {
    @Test
    fun `returns a 2D array`() {
        val levelUseCase = LevelUseCase()
        val result = levelUseCase.execute()

        assertTrue(result[0] is Array<*>)
    }
}