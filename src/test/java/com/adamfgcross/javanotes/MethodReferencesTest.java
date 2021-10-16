package com.adamfgcross.javanotes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MethodReferencesTest {
    // it's key to understand that the way a method reference is
    // interpreted has to do with the context---specifically with the
    // specific signature and return types of the functional expected.

    // there are four types of method reference
    // type one:
    // a method reference can replace a lambda of the sort (x)->f(x)
    // the four formats are
    // 1) static methods
    // 2) instance methods on a particular instance
    // 3) instance methods on a parameter to be determined at runtime
    // 4) constructors

    private static void add (Integer i) {

    }


    @Test
    void methodReference_static_method() {
        // random is a static method of Math
        Supplier<Double> supplier = Math::random;
        Stream<Double> myStream = Stream.generate(supplier);
        Double myDouble = myStream.limit(10).findAny().get();
    }

    @Test
    void methodReference_instance_method_1() {

        class TestObj {
            public void add(Integer i) {
            }
        }

        TestObj testObj = mock(TestObj.class);
        // method ref in a forEach on a stream
        IntStream.range(0,10)
                .forEach(testObj::add); // here testObj is an instance and add is a method of it
        verify(testObj, times(10)).add(anyInt());
    }
    

    @Test
    void methodReference_instance_method_2() {
        // this is also an example of a method referene
        // to a method on an instance
        class TestClass {
            public Boolean test(Integer i) {
                return null;
            }
        }

        TestClass testClass = mock(TestClass.class);
        Predicate<Integer> predicate = testClass::test;
        // the novelty here (to me) is just that a method reference can
        // stand alone on the right side of an assignment

        predicate.test(5);
        verify(testClass, times(1)).test(5);
    }


    @Test
    void varDeterminedAtRuntime() {
        Stream<Double> stream = Stream.generate(Math::random);// <- not the example method ref

        Stream<String> strings = stream.map(Object::toString);
        //Stream<String> strings2 = stream.map(Double::toString); // does not compile:
        // cannot resolve method toString
        // why doesn't this line compile?
        // the compiler says the reference to toString is ambiguous.
        // in the method reference format, there is no way to tell whether
        // I mean x -> Double.toString(x) or x-> x.toString()
        // The compiler does not seem to know or care that the results of the two
        // methods are the same.
    }
    @Test
    void varDeterminedAtRuntime_2() {
        Predicate<String> methodRef = String::isEmpty;
        assertEquals("", Stream.of("", "Apple", "")
                .filter(methodRef)
                .findAny()
                .get());
    }
    @Test
    void methodRefWithAConstructor() {
        Supplier<List<String>> listSupplier = ArrayList::new;

    }

    private interface MyFunctional1 {
        List<Integer> get(Integer i, Integer j);
    }
    private interface MyFunctional2 {
        List<Integer> get(Integer i, Integer j, Integer k);
    }

    // the meaning of a method reference depends on context
    @Test
    void weirdExample_1() {
        MyFunctional1 myFunctional1 = Arrays::asList;
        MyFunctional2 myFunctional2 = Arrays::asList;
        // myFunctional1 and myFunctional2 are not the same functional
        // note they both have a 'get' function, but with different signatures
        myFunctional1.get(3,4);
        // myFunctional1.get(3,4,5); // doesn't exist: won't compile
        myFunctional2.get(5,6,7);
    }


}
