package com.example.outsideintddexample

/**
 * Created by Brandon Quintanilla on Oct/27/2022
 */
class Car(val engine: Engine, var fuel: Double) {

    fun turnOn() {
        fuel -= 0.5
        engine.turnOn()
    }
}