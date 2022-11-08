package com.example.outsideintddexample

import kotlinx.coroutines.delay

/**
 * Created by Brandon Quintanilla on Oct/27/2022
 */
class Engine constructor(
    var isTurnedOn: Boolean = false,
    var temperature: Int = 15
) {

    suspend fun turnOn() {
        isTurnedOn = true
        delay(6000)
        temperature = 95
    }
}