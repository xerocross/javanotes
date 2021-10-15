package com.adamfgcross.javanotes;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


import static org.junit.jupiter.api.Assertions.*;

public class FunctionalsTest {

    @Test
    void predicateTest () {
        Predicate<Integer> isEven = x -> x % 2 == 0; // test if even
        assertEquals(false, isEven.test(7));
        //  we will see we cannot use isEven and we need to define an IntPredicate
        IntPredicate intIsEven = x -> x % 2 == 0;
        IntStream intStream = IntStream.rangeClosed(1,5);
        int arbitraryMultiplier = 5;
        Set<Integer> myIntegers =  intStream
                //.filter(isEven) // this doesn't compile because the required type is an IntPredicate
                .filter(intIsEven)
                .map(x -> arbitraryMultiplier*x) // a simple mapping lambda written in situ
                .boxed() // box to Integer type; the collect method on IntStream is complicated
                .collect(Collectors.toSet());
        assertEquals(new HashSet<>(Arrays.asList(10,20)), myIntegers);
        // note that Collectors.toSet() does not guarantee elements will be ordered
    }

    @Test
    void intSupplierTest() {
        IntSupplier supplier = () -> (int) Math.floor(100*Math.random());
        Supplier<IntSupplier> myDoubleSupplier = () -> supplier; // this obfuscation is completely unnecessary
        IntStream myStream = IntStream.generate(myDoubleSupplier.get());
        IntToLongFunction intToLongFunction = (x)-> x;


        List<Long> myRandomList = myStream
                .limit(20)
                .mapToLong(intToLongFunction)
                .boxed()
                .collect(Collectors.toList());
        assertEquals(20, myRandomList.size());
        for (Long i : myRandomList) {
            assertTrue(0 <= i && 100 >= i)    ;
        }
    }

    @Test
    void supplierTest() {
        System.out.println("Running test with a stream of boxed Integers from a randomized generator.");
        Supplier<Integer> supplier = () -> (int) Math.floor(100*Math.random());
        Stream<Integer> myStream = Stream.generate(supplier);
        var set = myStream
                .limit(50)
                .map(x-> x%2 == 0)
                .collect(Collectors.toList());

        // try removing the Integer parameter and see what happens with
//
//        Stream myStream2 = Stream.generate(supplier);
//        var set2 = myStream2
//                .limit(50)
//                .map(x-> x%2 == 0)
//                .collect(Collectors.toList());

        assertEquals(50, set.size());
        for (var i : set) {
            assertEquals(i.getClass(), Boolean.class);
        }
    }

    @Test
    static void testWithClosure() {
        int i = 0;
        // this will not compile because variables used in lambdas have
        // to be final or effectively final
//        Supplier<Integer> mySupplier = (x) -> {
//            i++;
//            int max = 30;
//            if (i < max) {
//                return (int) Math.floor(100 * Math.random());
//            } else {
//                return null;
//            }
//        };
    }

}
