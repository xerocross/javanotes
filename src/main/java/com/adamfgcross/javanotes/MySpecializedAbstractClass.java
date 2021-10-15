package com.adamfgcross.javanotes;

public abstract class MySpecializedAbstractClass {
    private String stateString = "I'm state";

    void p (Object o) {
        System.out.println(o);
    }

    void setStateString(String str) {
        this.stateString = str;
    }

    String getStateString() {
        return this.stateString;
    }
    abstract Integer doSomething(Integer e);
}
