package com.adamfgcross.javanotes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringTest {

    @Test
    void internStringTest() {
        System.out.println("Now doing some tests of string equality using the string interning.");
        String st1 = "hello world";
        String st2 = "hello world";
        String st3 = new String("hello world");
        String st4 = st3.intern();
        String st5 = new String("hello ").concat("world");
        String st6 = st5.intern();
        assertTrue(st1 == st2);
        assertFalse((st2 == st3));
        assertTrue( (st4 == st1));
        assertFalse((st5 == st1));
        assertTrue((st6 == st1));
    }

}
