package com.bnjn.duckadventure.domain.level.models

import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Test

class LevelGridTest {
    @Test
    fun `grid should return a 2D array with the correct dimensions when given 2 height and 2 width`() {
        val levelGrid = LevelGrid(2, 2)

        assertTrue(levelGrid.grid.size == 2)
        assertTrue(levelGrid.grid[0].size == 2)
        assertTrue(levelGrid.grid[1].size == 2)
    }

    @Test
    fun `grid should return a 2D array with the correct dimensions when given 10 height and 5 width`() {
        val levelGrid = LevelGrid(10, 5)

        assertTrue(levelGrid.grid.size == 10)

        levelGrid.grid.forEach {
            assertTrue(it.size == 5)
        }
    }

    @Test
    fun `the grid should contain only null values by default`() {
        val levelGrid = LevelGrid(10, 10)

        levelGrid.grid.forEach { row ->
            row.forEach { assertTrue(it == null) }
        }
    }

    @Test
    fun `throws an exception if the grid height is invalid`() {
        assertThrows(IllegalArgumentException::class.java) {
            LevelGrid(0, 3)
        }
    }

    @Test
    fun `throws an exception if the grid width is invalid`() {
        assertThrows(IllegalArgumentException::class.java) {
            LevelGrid(3, 0)
        }
    }

    @Test
    fun `throws an exception if the grid height and width are invalid`() {
        assertThrows(IllegalArgumentException::class.java) {
            LevelGrid(-4, -11)
        }
    }
}
