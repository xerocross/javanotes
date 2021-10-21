package com.adamfgcross.javanotes.birds;

import com.adamfgcross.javanotes.Animal;

public class Bird extends Animal {
    protected String identity = "I'm a bird";

    protected static void staticProtectedMethod() {
        System.out.println("bird: protected static method");
    }

    protected void protectedMethod () {
        System.out.println("protected bird method called");
    }

    private void privateMethod() {
        System.out.println("private bird method called");
    }

    @Override
    protected void doSomething() {

    }
}
