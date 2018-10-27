// JUnit 5 imports
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

//JUnit 5 no longer uses RunWith. Also Method source is handled slightly differently. I did not change the results.
class IsogramTest {
    companion object {
        @JvmStatic
        fun data() = Stream.of(
                Arguments.of("", true),
                Arguments.of("isogram", true),
                Arguments.of("eleven", false),
                Arguments.of("subdermatoglyphic", true),
                Arguments.of("Alphabet", false),
                Arguments.of("thumbscrew-japingly", true),
                Arguments.of("six-year-old", true),
                Arguments.of("Emily Jung Schwartzkopf", true),
                Arguments.of("accentor", false)
        )
    }

    @ParameterizedTest(name = "\"{0}\" should be \"{1}\"")
    @MethodSource("data")
    fun test(input :String, expectedOutput: Boolean) {
        assertEquals(expectedOutput, Isogram.isIsogram(input))
    }
}