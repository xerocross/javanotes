package com.adamfgcross.javanotes;

import org.junit.jupiter.api.Test;

public class NestedClassExperimentTest {

    @Test
    void testInnerClass() {
        NestedClassExperiment nestedClassExperiment = new NestedClassExperiment();
        // I can reverence a field that points to a NestedClassExperiment.MyInnerClassB
        System.out.println(nestedClassExperiment.myInnerClassB);
        // System.out.println(nestedClassExperiment.myInnerClassB.innerClassConstant); this won't compile. The field is inaccessible
    }
}
