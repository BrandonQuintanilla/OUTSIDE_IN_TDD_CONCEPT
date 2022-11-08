package com.example.outsideintddexample

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Brandon Quintanilla on Oct/27/2022
 */
class Car(val engine: Engine, var fuel: Double) {

    fun turnOn() {
        fuel -= 0.5
        CoroutineScope(Dispatchers.Main).launch {
            engine.turnOn()
        }
    }
}