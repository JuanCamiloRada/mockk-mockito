package co.jcrada.kotlin.creation

import co.jcrada.kotlin.Adder
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class MockitoCreationTest(
    @Mock private val annotationMock: Adder,
) {

    private val manualMock: Adder = Mockito.mock(Adder::class.java)

    @Test
    fun checkMocks() {
        assertNotNull(annotationMock)
        assertNotNull(manualMock)
    }
}

