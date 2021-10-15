package com.adamfgcross.javanotes;

import org.junit.jupiter.api.Test;

public class MyInterfaceWithDefaultTest {

    @Test
    void canCreateInstanceOfInterface() {


        class myClass implements MyInterfaceWithDefault {
            public String myString = "I'm state";
            // void doSomethingElse() {} // this would cause a compilation error on this line because the method clashes with public doSomethingElse
            // in the implementation, the interface method must be declared public
            public void doSomethingElse() {
                System.out.println("You should say something else.");
            }
        }

        //System.out.println(myClass.myString);  // this won't compile. It gives an error about trying to reference a
        // non-static field from a static context. That's because my locally defined class is still a class, not an
        // object instance of it
        // I mistakenly used a lowercase first letter, myClass
        // I'm leaving that in place

        myClass instanceClass = new myClass();
        System.out.println(instanceClass.myString);
        // doSomething is static
        // myClass.doSomething(); this doesn't compile
        MyInterfaceWithDefault.doSomething();
        System.out.println(instanceClass.constant);
        //instanceClass.constant = "no, I'm not constant"; can't do that because the field is implicitly final
        System.out.println(myClass.constant);
        System.out.println(MyInterfaceWithDefault.constant);
        System.out.println(MyInterfaceWithDefault.constant);


    }

}
