package co.jcrada.kotlin.matchers

import co.jcrada.kotlin.Adder
import co.jcrada.kotlin.Multiplier
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class MockkMatcherTest(@MockK private val adder: Adder) {
    private val testInstance = Multiplier(adder)

    @Test
    fun mockingMatchers() {
        every { adder.add(any(), 1) } returns 2
        assertEquals(2, testInstance.multiple(1, 1))
    }

    @Test
    fun mockingMatchers2() {
        every { adder.add(match { it >= 0 }, 1) } returns 2
        assertEquals(2, testInstance.multiple(1, 1))
    }
}