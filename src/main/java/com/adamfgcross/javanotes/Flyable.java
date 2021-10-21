package com.adamfgcross.javanotes;

public interface Flyable {
    Boolean canFly = true;
    // a field on an interface like canFly is implicitly final and static

    public void fly();// public is redundant

    default void soar() {
        System.out.println("flyable is soaring");
        fly();
        coast();
    }

    //protected void turn(); protected modifier not allowed

    private void coast() { // note that an interface can have private methods
        System.out.println("flyable is coasting");
    }
}
