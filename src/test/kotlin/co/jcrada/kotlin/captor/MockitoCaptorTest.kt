package co.jcrada.kotlin.captor

import co.jcrada.kotlin.Adder
import co.jcrada.kotlin.Multiplier
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class MockitoCaptorTest(
    @Mock private val adder: Adder,
) {
    private val testInstance = Multiplier(adder)

    @Test
    fun argumentCaptor() {
        val intCaptor = ArgumentCaptor.forClass(Int::class.java)
        `when`(adder.add(anyInt(), eq(1))).thenReturn(1)

        assertEquals(testInstance.multiple(1, 1), 1)
        verify(adder).add(intCaptor.capture(), eq(1))
        assertEquals(intCaptor.value, 0)
    }
}

