package com.adamfgcross.javanotes;

public interface MyInterfaceWithDefault {
    String constant = "I'm constant";
    // implicitly public static final

    public static void doSomething() {
        System.out.println("I'm a function defined in an interface");
    }

    // you don't have to write 'public', but you can. It's implied either way.
    public void doSomethingElse();
}
