package com.adamfgcross.javanotes;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class CharsAndStringsTest {

    @Test
    void testCharAt() {
        String testString = "hello world";
        assertEquals('h', testString.charAt(0));
    }
    @Test
    void testCharArray() {
        String testString = "hello world";
        char[] charArray = testString.toCharArray();
        assertEquals('h', charArray[0]);
    }


    @Test
    void stringToCharList() {
        String testString = "hello world";
        char[] charArray = testString.toCharArray();
        List<Character> charList = new ArrayList<>();
        for (char c : charArray) {
            charList.add(c);
        }
        assertEquals('h', charList.get(0));
    }


    @Test
    void findDuplicateChars() {
        // find all chars that occur more than once and return them as a List<Character> in order.
        String testString = "Lorem ipsum dolor sit amet, consectetur.";
        char[] charArray = testString.toCharArray();
        List<Character> charList = new ArrayList<>();
        for (char c : charArray) {
            charList.add(c);
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : charList) {
            if (map.keySet().contains(c)) {
                map.put(c,map.get(c) +1);
            } else {
                map.put(c, 1);
            }
        }
        System.out.println(map);
        List<Character> dupes =  map.keySet().stream()
                .filter(x-> map.get(x) >= 2)
                .collect(Collectors.toList());
        System.out.println(dupes);
    }

    @Test
    void compareCharsWithStrings() {
        String test = "Lorem ipsum dolor sit amet, consectetur.";
        List<String> charStrings = new ArrayList<>();

        for (char c : test.toCharArray()) {
            charStrings.add(String.valueOf(c));
        }

        System.out.println(charStrings);
    }

}
