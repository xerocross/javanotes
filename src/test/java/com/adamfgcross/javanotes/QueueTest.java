package com.adamfgcross.javanotes;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueTest {

    @Test
    void testNormalQueueOperations_peek() {
        // a queue is first in first out
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        assertEquals(5, queue.peek());
        assertEquals(5, queue.peek());
    }

    @Test
    void testNormalQueueOperations_poll() {
        // a queue is first in first out
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        assertEquals(5, queue.poll());
        assertEquals(6, queue.poll());
    }

    @Test
    void testNormalStackOperations() {
        // a queue is first in first out
        Deque<Integer> stack = new LinkedList<>();
        stack.push(5);
        stack.push(7);
        stack.push(3);
        assertEquals(3, stack.peek());
        assertEquals(3, stack.peek());
        assertEquals(3, stack.pop());
        assertEquals(7, stack.pop());
    }
}
