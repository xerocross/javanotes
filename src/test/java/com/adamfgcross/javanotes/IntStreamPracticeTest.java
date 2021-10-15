package com.adamfgcross.javanotes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntStreamPracticeTest {

    @Test
    void charAtTest () {
        String str = "test";
        List<Character> charList = new ArrayList<>();
        IntStream.range(0, str.length()).forEach(i -> {
            charList.add(str.charAt(i));
        });
        System.out.println("charList: " + charList.toString());
        assertEquals(Arrays.asList('t', 'e', 's', 't'), charList);
    }

    @Test
    void intStreamAverageProducesOptionalDouble() {
        IntStream stream = IntStream.of(9, 5, 5);
        assertEquals(OptionalDouble.of(6D + 1.0 / 3), stream.average());
    }
    @Test
    void averageOfEmptyStream() {
        assertEquals(OptionalDouble.empty(), IntStream.empty().average());
    }
}
