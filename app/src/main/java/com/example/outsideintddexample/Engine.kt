package com.example.outsideintddexample

/**
 * Created by Brandon Quintanilla on Oct/27/2022
 */
class Engine constructor(
    var isTurnedOn: Boolean = false,
    var temperature: Int = 15
) {

    fun turnOn() {
        isTurnedOn = true
        temperature = 95
    }
}