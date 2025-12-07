package com.bnjn.duckadventure.domain.level.models

class Player(
    position: Pair<Int, Int>,
) {
    private var playerPosition: Pair<Int, Int> = position

    fun getPosition(): Pair<Int, Int> = playerPosition

    fun move(amount: Pair<Int, Int>) {
        playerPosition = Pair(playerPosition.first + amount.first, playerPosition.second + amount.second)
    }
}
