package com.adamfgcross.javanotes;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class IteratingTest {

    @Test
    void hasDoLoop() {
        var x = 5;
        // x = false; won't compile -- required type int
        //
        do {
            x++;
        } while (x < 10);
        assertEquals(10, x);
    }

    @Test
    void canIterateUsingIterator() {
        Iterable<Integer> set = new HashSet<>(Arrays.asList(5,9,9));
        // the set will accept only one copy of 9
        Iterator<Integer> itr = set.iterator(); // sets are iterable
        int sum = 0;

        while (itr.hasNext()) {
            sum += itr.next();
        }
        assertEquals(14 , sum);
    }

    @Test
    void canUseForEachOverAnIterable() {
        Iterable<Integer> list = new ArrayList<>(Arrays.asList(5,9,9));
        // we can store a list as an Iterable
        int sum = 0;

        // you can write a for-each list over any iterable
        for (Integer x : list) {
            sum+=x;
        }
        assertEquals(23 , sum);
    }

    @Test
    void canIterateOverAQueue() {
        int sum = 0;
        // Queue<Integer> list1 = new ArrayList<Integer>(Arrays.asList(5,9,9));
        // does not compile. arrayList does not implement the Queue interface
        // but LinkedList does
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(5,9,9));
        queue.offer(10);
        queue.offer(8);
        Iterable<Integer> myIterable = queue;
        // we can store a queue as an Interable

        // you can write a for-each list over any iterable
        for (Integer x : myIterable) {
            sum+=x;
        }
        assertEquals(5+9+9+10+8 , sum);
    }

}
