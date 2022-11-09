package com.example.outsideintddexample.unittest

import com.example.outsideintddexample.Engine
import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.toList
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
    fun riseTemperatureGraduallyWhenItTurnsOn() = runTest{
        val flow = engine.turnOn()
        val actual = flow.toList() //Espera a que los emits() del flow terminen para colocarlos en una lista

        assertEquals(listOf(25,50,95), actual)
    }
}