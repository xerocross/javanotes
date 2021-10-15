package com.adamfgcross.javanotes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class AutoBoxingAndLambdaTest {


    static private void consume(Object x) {

    }

    @Test
    void main() {
        Consumer<Integer> myConsumer = (x) -> consume(x);

        // cannot use primitive and write Consumer<int>
        // however: what if we don't check the type?
        Consumer myRawConsumer = x -> {
            System.out.println(x.getClass());
            System.out.println(x.toString());
        };
        int myInt = 5;
        assertDoesNotThrow(()->{
            myRawConsumer.accept(myInt);
        });


        // when given an integer value
        // because the toString method on x works inside the lambda, it looks like
        // x gets autoboxed to an Integer type

        // now let's try IntConsumer
        IntConsumer intConsumer = x -> {
            //consume(x.getClass()); //does not compile because you cannot call a method on a primitive
            consume(x);
        };
    }
}
