package com.adamfgcross.javanotes.birds;

import com.adamfgcross.javanotes.Flyable;
import com.adamfgcross.javanotes.HuntCapable;

public class Falcon extends Bird implements Flyable, HuntCapable {

    public static void main(String[] args) {
        Falcon falcon = new Falcon();
        falcon.soar();
        falcon.hunt();
        falcon.capture();
        falcon.doSomething();
        System.out.println("canFly constant on instance:" + falcon.canFly);
        System.out.println("canFly constant on class:" + Falcon.canFly); // canFly is implicitly Static
        falcon.defend();
        System.out.println("status : " + falcon.status);
        //  Falcon.canFly = false; // canFly is implicitly final
        // falcon.coast(); // no access. coast() is private
    }
    @Override
    public void doSomething () {
        System.out.println("falcon is doing something");
    }

    @Override
    public void fly () {
        System.out.println("falcon is flying");
    }

    @Override
    public void hunt() {
        System.out.println("falcon is hunting");
    }
}
