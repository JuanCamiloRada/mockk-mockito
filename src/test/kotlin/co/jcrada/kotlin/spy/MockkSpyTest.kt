package co.jcrada.kotlin.spy

import co.jcrada.kotlin.Adder
import co.jcrada.kotlin.Multiplier
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.spyk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class MockkSpyTest {

    @Test
    fun simpleSpy() {
        val spyMultiplier = spyk(Multiplier(Adder()))
        Assertions.assertEquals(4, spyMultiplier.multiple(1, 4))

        every { spyMultiplier.multiple(1, 4) } returns 5
        Assertions.assertEquals(spyMultiplier.multiple(1, 4), 5)
    }
}