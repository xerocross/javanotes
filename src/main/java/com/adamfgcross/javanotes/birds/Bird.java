package com.adamfgcross.javanotes.birds;

public class Bird {
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
}
