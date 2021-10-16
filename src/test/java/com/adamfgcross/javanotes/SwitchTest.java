package com.adamfgcross.javanotes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class SwitchTest {

    static enum MyEnum {
        A, B, C, D
    }


    @Test
    void testWhetherDefaultSwitchCanBeFirst() {

        var x = 5;
        //var y; doesn't compile. obviously a var has to be defined on the same line so its type
        // can be inferred
        int y = 0;

        switch(x) {
            default:
                y+=3;
            case 2:
                y+= 5;
                break;
            case 1:
                y=4;
                break;
        }
        assertEquals(8, y);
    }

    @Test
    void testHowStringSwitchWorks() {

        final String str1 = "hello world";
        final String str2 = new String("hello world");
        final String str3 = str2.intern();

        var x = str2;
        final String z = "welcome";
        var y = 0;
        switch(x) {
            default:
                y+=3;
//            case str1: The compiler is smart enough to see that this case is a duplicate of "hello world"
////                y+=3;
            case "hello world":
                y+= 5;
                break;
        }
        assertEquals(5, y);
    }

    @Test
    void testHowEnumSwitchWorks() {

        var x = MyEnum.A;

        var y = 0;
        switch(x) {
            default:
                y+=3;
            case A: // how does the compiler know which enum I'm talking about for these values?
                y+= 5;
                break;
            case B:
                y+= 8;
                break;
        }
        assertEquals(5, y);
    }

    @Test
    void testHowEnumSwitchWorks_2() {

        var x = SomeEnum.AA;

        var y = 0;
        switch(x) {
            default:
                y+=3;
            case AA: // I suppose it knows where AA comes from by the type of x.
                y+= 5;
                break;
            case CC:
                y+= 8;
                break;
        }
        assertEquals(5, y);
    }

}
