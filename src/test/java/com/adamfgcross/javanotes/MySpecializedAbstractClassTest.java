package com.adamfgcross.javanotes;

import org.junit.jupiter.api.Test;

public class MySpecializedAbstractClassTest {


    @Test
    void createAbstractClass() {
        // an example of using an anonymous class to define an instance of an abstract class
        MySpecializedAbstractClass myClass = new MySpecializedAbstractClass() {
            @Override
            public Integer doSomething(Integer x) {
                return x+2;
            }
        };
        myClass.p(myClass.getStateString());
    }
}
