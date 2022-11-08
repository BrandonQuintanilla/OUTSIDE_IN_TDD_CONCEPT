package com.example.outsideintddexample.unittest

import com.example.outsideintddexample.Engine
import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

/**
 * Created by Brandon Quintanilla on Oct/27/2022
 */
class EngineShould {

    private val engine = Engine()

    @get:Rule
    var coroutineTestRule = MainCoroutineScopeRule()

    @Test
    fun turnOn() = runTest{
        engine.turnOn()
        assertTrue(engine.isTurnedOn)
    }

    @Test
    fun riseTemperatureWhenItTurnsOn() = runTest{
        engine.turnOn()
        assertEquals(95, engine.temperature)
    }
}