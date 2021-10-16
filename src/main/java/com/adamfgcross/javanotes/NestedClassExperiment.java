package com.adamfgcross.javanotes;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NestedClassExperiment {

    public static void main(String[] args) {
        System.out.println("Running NestedClassExperiment");
        NestedClassExperiment nestedClassExperiment = new NestedClassExperiment();
        System.out.println(nestedClassExperiment.myInnerClass.innerClassConstant);
        NestedClassExperiment.MyInnerClass myInnerClass = nestedClassExperiment.myInnerClass; // since I marked the inner class public
        // I can reach it here.
        NestedClassExperiment.MyInnerClassB myInnerClassB = nestedClassExperiment.myInnerClassB; // since we are inside NestedClassExperiment
        // we can still reach this private inner class. However, see NestedClassExperimentTest


    }


    static String someConstant = "someConstant";
    String someOtherConstant = "A";
    MyInnerClass myInnerClass;
    MyInnerClassB myInnerClassB;

    public NestedClassExperiment() {
        myInnerClass = new MyInnerClass();
        myInnerClassB = new MyInnerClassB();
    }
    static class StaticNestedClass {
        String state = "I can do anything";

        public void doSomething() {
            System.out.println(state);
            System.out.println(someConstant); // <- this is allowed because someConstant is static
            // System.out.println(someOtherConstant); this won't compile because NestedClassExperiment does not have access to someOtherConstant
        }
    }

    // why would I use an inner class?
    public class MyInnerClass { // what does marking it public do exactly?
        public String innerClassConstant = "innerClassConstant";
        String comp() {
            return innerClassConstant + someOtherConstant; // it can access outer class instance variables
        }
    }
    private class MyInnerClassB { // what does marking it public do exactly?
        public String innerClassConstant = "innerClassConstant";

        String comp() {
            return innerClassConstant + someOtherConstant; // it can access outer class instance variables
        }
    }

    private List<String> readInSomeDataAndDoSomething() {

        // public class MyLocalClass { modifier public not allowed here
        // protected class MyLocalClass { protected not allowed
        //static class MyLocalClass { // static not allowed here
        //private class MyLocalClass { private not allowed here
        class MyLocalClass {
            String field1;
            String field2;
            String doSomeComputation() {
                // uses the fields
                return null; // dummy method in reality would perform some operation
            }

        }
        // read a file containing raw data and group it into a list of instances of MyLocalClass
        List<MyLocalClass> myDataFromTheFile = new ArrayList<>(); // it's empty because I'm not
        // really going to create a file to read it.
        return myDataFromTheFile
                .stream()
                .map(MyLocalClass::doSomeComputation)
                .collect(Collectors.toList());
    }

    private List<Runnable> useAnAnonymousClass() {
        List<Runnable> myRunnables = new ArrayList<>();
        myRunnables.add(new Runnable() {
            @Override
            public void run() {
                /// do something anonymously
            }
        });
        return myRunnables;
    }

}
