package co.jcrada.kotlin.mocks

import co.jcrada.kotlin.Adder
import co.jcrada.kotlin.Multiplier
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class MockkMockingTest(@MockK private val adder: Adder) {

    private val testInstance = Multiplier(adder)

    @Test
    fun simpleMocking() {
        every { adder.add(0, 1) } returns 1

        assertEquals(1, testInstance.multiple(1, 1))
    }

    @Test
    fun multipleMocking() {
        every { adder.add(any(), 1) } returnsMany listOf(1, 2, 3)
        assertEquals(3, testInstance.multiple(1, 3))

        every { adder.add(any(), 1) } returns 1 andThen 2 andThen 3
        assertEquals(3, testInstance.multiple(1, 3))
    }

    @Test
    fun voidMocking() {
        every { adder.print(1) } returns Unit

        testInstance.print(1)
    }

    @Test
    fun customerAnswer() {
        every { adder.add(any(), any()) } answers { firstArg<Int>() + secondArg<Int>() }

        assertEquals(6, testInstance.multiple(3, 2))
    }
}

