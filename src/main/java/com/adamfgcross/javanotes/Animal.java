package com.adamfgcross.javanotes;

public abstract class Animal {

    protected String status;
    protected abstract void doSomething();

    public void defend () {
        System.out.println("Animal is defending itself");
        status = "Defensive";
    }
}
