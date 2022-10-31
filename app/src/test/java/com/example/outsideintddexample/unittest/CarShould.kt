package com.example.outsideintddexample.unittest

import com.example.outsideintddexample.Car
import com.example.outsideintddexample.Engine
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.mockito.Mockito.verify
import org.mockito.kotlin.mock
import org.mockito.kotlin.times

/**
 * Created by Brandon Quintanilla on Oct/27/2022
 */
class CarShould {

    private val engine: Engine = mock()
    val car = Car(engine, 6.0)

    @Test
    fun looseFuelWhenItTurnsOn() {
        car.turnOn()
        assertEquals(4.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine() {
        car.turnOn()
        verify(engine, times(1)).turnOn()
    }
}