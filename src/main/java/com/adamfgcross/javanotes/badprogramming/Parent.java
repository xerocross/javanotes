package com.adamfgcross.javanotes.badprogramming;


import java.io.FileNotFoundException;
import java.io.IOException;

public class Parent {

    public void doSomething() {
        Parent p = this;
        this.speak();
    }

    public void get() throws FileNotFoundException {

    }

    public void getB() throws IOException {

    }

    public void speak () {
        System.out.println("I'm a Parent object");
    }
}
