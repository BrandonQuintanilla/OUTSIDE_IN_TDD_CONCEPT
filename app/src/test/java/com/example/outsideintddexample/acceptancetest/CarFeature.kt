package com.example.outsideintddexample.acceptancetest

import com.example.outsideintddexample.Car
import com.example.outsideintddexample.Engine
import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class CarFeature {

    private val engine = Engine()
    private val car = Car(engine, 6.0)

    @get:Rule
    var coroutineTestRule = MainCoroutineScopeRule()

    @Test
    fun carIsLoosingFuelWhenItTursOn() = runTest {

        car.turnOn()
        assertEquals(5.5, car.fuel)
    }

    @Test
    fun carIsTurningOnItsEngineAndIncreaseTheTemperature() = runTest {
        car.turnOn()

        //Permite esperar el tiempo que turnOn demora en ejecutarse
        coroutineTestRule.advanceTimeBy(60000)

        assertEquals(95, car.engine.temperature)
        assertTrue(car.engine.isTurnedOn)
    }

}