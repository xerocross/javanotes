package com.adamfgcross.javanotes;

public interface HuntCapable {

    void hunt();

    default void capture() {
        System.out.println("HuntCapable captures prey");
    }
}
