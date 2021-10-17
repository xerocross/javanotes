package com.adamfgcross.javanotes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NestedClassExperimentTest {

    @Test
    void testInnerClass() {
        NestedClassExperiment nestedClassExperiment = new NestedClassExperiment();
        // I can reference a field that points to a NestedClassExperiment.MyInnerClassB
        System.out.println(nestedClassExperiment.myInnerClassB);
        // System.out.println(nestedClassExperiment.myInnerClassB.innerClassConstant); this won't compile. The field is inaccessible
    }

    @Test
    void testInnerClass2() {
        NestedClassExperiment nestedClassExperiment = new NestedClassExperiment();
        // NestedClassExperiment.MyInnerClass myInnerClass = new nestedClassExperiment.MyInnerClass();
        // the above line does not compile and is probably nonsense.
        NestedClassExperiment.MyInnerClass myInnerClass = nestedClassExperiment.new MyInnerClass();
        // turns out I just had the syntax wrong.
        System.out.println("inner class constant: " + myInnerClass.innerClassConstant);
        System.out.println(nestedClassExperiment.myInnerClassB);
        assertNotEquals(nestedClassExperiment.myInnerClassB, myInnerClass);
        // System.out.println(nestedClassExperi4ment.myInnerClassB.innerClassConstant); this won't compile. The field is inaccessible
    }

    @Test
    void testPrivateNestedClass() {
        // NestedClassExperiment.Range range = NestedClassExperiment.Range.of(3,5);
        // this doesn't compile because Range is a _private_ nexted class.
        System.out.println(NestedClassExperiment.getRange(2, 5)); // but even though
        //  you cannot define what NestedClassExperiment.Range is from outside
        // you can still get one as a response from a method?
        // NestedClassExperiment.Range o = NestedClassExperiment.getRange(2,4); not allowed;
        Object o = NestedClassExperiment.getRange(2,4);
        System.out.println(o.getClass());
        // this proves that you can have a reference to an object of a given class
        // even though you don't have access to that class
    }
}
