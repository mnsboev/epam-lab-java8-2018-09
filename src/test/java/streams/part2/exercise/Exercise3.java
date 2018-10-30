package streams.part2.exercise;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SuppressWarnings({"unused", "ConstantConditions"})
class Exercise3 {

    @Test
    void createLimitedStringWithOddNumbersSeparatedBySpaces() {
        int countNumbers = 10;

        String result = IntStream.iterate(0, x -> x + 1)
                .filter(x -> x % 2 != 0)
                .limit(countNumbers)
                .mapToObj(String::valueOf)
                .collect(joining(" "));

        assertThat(result, is("1 3 5 7 9 11 13 15 17 19"));
    }

    @Test
    void extractEvenNumberedCharactersToNewString() {
        String source = "abcdefghijklm";
        String result = IntStream.range(0, source.length())
                .filter(x -> x % 2 == 0)
                .mapToObj(x -> String.valueOf(source.charAt(x)))
                .collect(Collectors.joining(""));

        assertThat(result, is("acegikm"));
    }
}
