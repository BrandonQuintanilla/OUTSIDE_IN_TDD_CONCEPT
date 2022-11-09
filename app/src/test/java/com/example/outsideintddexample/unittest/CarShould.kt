package com.example.outsideintddexample.unittest

import com.example.outsideintddexample.Car
import com.example.outsideintddexample.Engine
import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.verify
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.whenever

/**
 * Created by Brandon Quintanilla on Oct/27/2022
 */
class CarShould {

    private val engine: Engine = mock()
     private val car:Car

//    private val testDispatcher = TestCoroutineDispatcher()
//    private val testScope = TestCoroutineScope(testDispatcher)

    @get:Rule
    var coroutineTestRule = MainCoroutineScopeRule()

    init {
        runTest {
            //Crea un mock para dich función en especifico!
            whenever(engine.turnOn()).thenReturn(flow {
                delay(2000)
                emit(25)
                delay(2000)
                emit(50)
                delay(2000)
                emit(95)

            })
        }
        car = Car(engine, 6.0)
    }

    @Test
    fun looseFuelWhenItTurnsOn() = runTest() {
        car.turnOn()
        assertEquals(5.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine() = runTest() {
        car.turnOn()
        verify(engine, times(1)).turnOn()
    }
}