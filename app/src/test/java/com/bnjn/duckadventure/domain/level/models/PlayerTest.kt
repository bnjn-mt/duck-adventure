package com.bnjn.duckadventure.domain.level.models

import org.junit.Assert.assertTrue
import org.junit.Test

class PlayerTest {
    @Test
    fun `a player should have a position`() {
        val player = Player(Pair(2, 2))

        assertTrue(player.getPosition() == Pair(2, 2))
    }

    @Test
    fun `player should be able to move one space forward horizontally`() {
        val player = Player(Pair(2, 2))
        player.move(Pair(0, 1))

        assertTrue(player.getPosition() == Pair(2, 3))
    }

    @Test
    fun `player should be able to move one space backward horizontally`() {
        val player = Player(Pair(2, 2))
        player.move(Pair(0, -1))

        assertTrue(player.getPosition() == Pair(2, 1))
    }

    @Test
    fun `player should be able to move one space forward vertically`() {
        val player = Player(Pair(2, 2))
        player.move(Pair(1, 0))

        assertTrue(player.getPosition() == Pair(3, 2))
    }

    @Test
    fun `player should be able to move one space backward vertically`() {
        val player = Player(Pair(2, 2))
        player.move(Pair(-1, 0))

        assertTrue(player.getPosition() == Pair(1, 2))
    }
}
