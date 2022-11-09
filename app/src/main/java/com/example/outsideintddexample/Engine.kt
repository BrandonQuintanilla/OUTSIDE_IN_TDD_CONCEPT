package com.example.outsideintddexample

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by Brandon Quintanilla on Oct/27/2022
 */
class Engine constructor(
    var isTurnedOn: Boolean = false,
    var temperature: Int = 15
) {

    suspend fun turnOn() : Flow<Int> {
        isTurnedOn = true

        return flow{
            delay(2000)
            temperature = 25
            emit(temperature)

            delay(2000)
            temperature = 50
            emit(temperature)

            delay(2000)
            temperature = 95
            emit(temperature)

        }
    }
}