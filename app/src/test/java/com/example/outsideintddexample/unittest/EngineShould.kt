package com.example.outsideintddexample.unittest

import com.example.outsideintddexample.Engine
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

/**
 * Created by Brandon Quintanilla on Oct/27/2022
 */
class EngineShould {

    private val engine = Engine()

    @Test
    fun turnOn() {
        engine.turnOn()
        assertTrue(engine.isTurnedOn)
    }

    @Test
    fun riseTemperatureWhenItTurnsOn() {
        engine.turnOn()
        assertEquals(95, engine.temperature)
    }
}