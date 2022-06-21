package co.jcrada.kotlin.spy

import co.jcrada.kotlin.Adder
import co.jcrada.kotlin.Multiplier
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.spy
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class MockitoMockingTest {

    @Test
    fun simpleSpy() {
        val spyMultiplier = spy(Multiplier(Adder()))
        assertEquals(spyMultiplier.multiple(1, 4), 4)

        `when`(spyMultiplier.multiple(1, 4)).thenReturn(5)
        assertEquals(spyMultiplier.multiple(1, 4), 5)
    }
}