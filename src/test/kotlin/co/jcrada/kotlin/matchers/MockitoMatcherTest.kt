package co.jcrada.kotlin.matchers

import co.jcrada.kotlin.Adder
import co.jcrada.kotlin.Multiplier
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.eq
import org.mockito.ArgumentMatchers.intThat
import org.mockito.Mock
import org.mockito.Mockito.reset
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class MockitoMatcherTest(@Mock private val adder: Adder) {
    private val testInstance = Multiplier(adder)

    @BeforeEach
    fun beforeEach() {
        reset(adder)
    }

    @Test
    fun mockingMatchers() {
        `when`(adder.add(anyInt(), eq(1))).thenReturn(2)
        assertEquals(2, testInstance.multiple(1, 1))
    }

    @Test
    fun mockingMatchers2() {
        `when`(adder.add(intThat { it >= 0 }, eq(1))).thenReturn(2)

        assertEquals(2, testInstance.multiple(1, 1))
    }
}