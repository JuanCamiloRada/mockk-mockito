package co.jcrada.kotlin.creation

import co.jcrada.kotlin.Adder
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class MockkCreationTest(
    @MockK private val annotationMockk: Adder,
) {
    private val manualMockk: Adder = mockk()

    @Test
    fun checkMocks() {
        assertNotNull(annotationMockk)
        assertNotNull(manualMockk)
    }
}