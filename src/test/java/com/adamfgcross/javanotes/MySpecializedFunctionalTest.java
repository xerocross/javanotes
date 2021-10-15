package com.adamfgcross.javanotes;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MySpecializedFunctionalTest {

    @Test
    void canCreateInstanceOfSpecializedFunctional() {
        MySpecializedFunctional mySpecializedFunctional = x -> x+2;
    }

    @Test
    void canCreateInstanceOfSpecializedFunctional_localClass() {

        MySpecializedFunctional mySpecializedFunctional = new MySpecializedFunctional() {
            @Override
            public Integer run(Integer x) {
                return x + 2;
            }
        };
        Stream<Integer> stream = Stream.of(3, 5, 6, 5);
        List<Integer> myList = stream
                .map(mySpecializedFunctional::run)
                .collect(Collectors.toList());
        System.out.println(myList);
        assertEquals(5, myList.get(0));
    }
}
