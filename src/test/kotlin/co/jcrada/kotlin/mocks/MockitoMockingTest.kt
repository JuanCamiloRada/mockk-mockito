package co.jcrada.kotlin.mocks

import co.jcrada.kotlin.Adder
import co.jcrada.kotlin.Multiplier
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mock
import org.mockito.Mockito.doAnswer
import org.mockito.Mockito.doNothing
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class MockitoMockingTest(@Mock private val adder: Adder) {

    private val testInstance = Multiplier(adder)

    @Test
    fun simpleMocking() {
        `when`(adder.add(0, 1)).thenReturn(1)

        assertEquals(1, testInstance.multiple(1, 1))
    }

    @Test
    fun multipleMocking() {
        `when`(adder.add(anyInt(), eq(1))).thenReturn(1, 2, 3)
        assertEquals(3, testInstance.multiple(1, 3))

        `when`(adder.add(anyInt(), eq(1))).thenReturn(1).thenReturn(2).thenReturn(3)
        assertEquals(3, testInstance.multiple(1, 3))
    }

    @Test
    fun voidMocking() {
        doNothing().`when`(adder).print(1)

        testInstance.print(1)
    }

    @Test
    fun customerAnswer() {
        doAnswer {
            it.getArgument<Int>(0) + it.getArgument<Int>(1)
        }.`when`(adder).add(anyInt(), anyInt())

        assertEquals(6, testInstance.multiple(3, 2))
    }
}