package co.jcrada.kotlin.captor

import co.jcrada.kotlin.Adder
import co.jcrada.kotlin.Multiplier
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.slot
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class MockkCaptorTest(
    @MockK private val adder: Adder,
) {
    private val testInstance = Multiplier(adder)

    @Test
    fun argumentCaptor() {
        val captor = slot<Int>()
        every { adder.add(capture(captor), 1) } returns 1

        assertEquals(1, testInstance.multiple(1, 1))
        assertEquals(captor.captured, 0)
    }
}