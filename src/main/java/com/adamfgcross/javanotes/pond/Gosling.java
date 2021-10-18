package com.adamfgcross.javanotes.pond;

import com.adamfgcross.javanotes.birds.Bird;

public class Gosling extends Bird {
    private String identity = "I'm a gosling"; // shadows the value in Bird

    public static void main(String[] args) {
        System.out.println("from inside gosling: ");
        Gosling gosling = new Gosling();
        staticProtectedMethod();
        gosling.protectedMethod(); // gosling can call this method of Bird.
        // gosling.privateMethod(); // this doesn't compile. Gosling does not have access to private methods in Bird
        System.out.println(gosling.identity); // defining identity above seems to shadow the value from Bird
        // I don't see any way to get the parent identity value
        gosling.doSomethingTricky();
        gosling.staticProtectedMethod();
    }

    void doSomethingTricky() {
        Bird bird = new Gosling();
        // bird.protectedMethod(); // this does not compile even though we are in
        // a child class of Bird

        Duck duck = new Duck();
        // duck.protectedMethod(); also doesn't compile
        // even though
    }
}
