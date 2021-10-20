package com.adamfgcross.javanotes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadsPractice {

    public static void main(String[] args) {
        System.out.println("Main start");
        useOldFashioned();
        useNewFangled();
        System.out.println("Main end");
    }

    static void useOldFashioned() {
        Runnable run1 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 1: ||||||||||| " + i);
            }
        };
        Runnable run2 = new Runnable() {
            @Override public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread 2: |||||||||||||||||||||| " + i);
                }
            }
        };
        Thread thread1 = new Thread(run1);
        Thread thread2 = new Thread(run2);
        thread1.start();
        thread2.start();
        // expectation is that the "Thread 1" counter
        // and the "Thread 2" counter might be mixed together.
        // But there is no guarantee.
    }

    static void useNewFangled() {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(()->{
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread 3: ||||||||||||||||||||||||||||||||| " + i);
                }
                System.out.println("Thread 3 complete");
            });

        } finally {
            if (service != null) service.shutdown();
        }
    }

}
