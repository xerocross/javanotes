package com.adamfgcross.javanotes.badprogramming;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Child extends Parent {

    public static void main(String[] args) {
        Child c = new Child();
        c.doSomething();
    }

//    @Override
//    public void get() throws IOException {
//        throw new IOException();
//    }

    @Override
    public void getB() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    @Override
    public void speak() {
        System.out.println("I'm a Child object");
    }
}
