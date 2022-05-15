import BracketsChecker.Companion.checker

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class TestBracketsChecker {

    companion object {
        @JvmStatic
        fun checkerTestArguments(): Stream<Arguments> =
            Stream.of(
                Arguments.of("(){12}(po1)(<12>)", "Success"),
                Arguments.of("{12}([w])1", "Success"),
                Arguments.of("({12}(po1)<12>)", "Success"),
                Arguments.of("123-{1}", "Success"),
                Arguments.of("{[}", "3"),
                Arguments.of("([]))[", "5"),
                Arguments.of("foo(bar[i)", "10"),
                Arguments.of(")[1]2[3](", "1")
            )
    }

    @ParameterizedTest
    @MethodSource("checkerTestArguments")
    fun testChecker (input: String, expectedResult: String) {
        val actualResult = checker(input.toCharArray())
        assertEquals(expectedResult, actualResult)
    }
}