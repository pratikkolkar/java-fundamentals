package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/* 
 * Data Race Condition: Data race condition occurs when one thread accesses mutable object while other thread 
 *                      is writing into it. 
 * 
 * To avoid this we have two ways:
 * 1. Use Atomic Integer : Atomic operations are lightwieght and efficient for simple programs
 * 2. Use syncronized keyword: Its preferred in complex program as it ensured the gaurantee but has overhead.
 */

public class MT02DataRaceCondition {
    public static void main(String[] args) throws InterruptedException {
        SharedObject counter = new SharedObject();

        new Thread(() -> {
            System.out.println("Thread 1 Started");
            for (int i = 0; i < 50000; i++) {
                counter.increament();
            }
            System.out.println("Thread 1 Completed");
        }).start();

        new Thread(() -> {
            System.out.println("Thread 2 Started");
            for (int i = 0; i < 50000; i++) {
                counter.increament();
            }
            System.out.println("Thread 2 Completed");
        }).start();

        Thread.sleep(3000);

        System.out.println("Final Count: " + counter.getCount());

    }
}

/**
 * InnerMT02DataRaceCondition
 */
class SharedObject {
    //Option 1:
    private AtomicInteger count = new AtomicInteger();
   
    

    public void increament() {
        this.count.incrementAndGet();
    }

    public int getCount() {
        return this.count.get();
    }

    // Option 2:
   /*  private int count = 0;
    public synchronized void increament() {
        this.count++;
    }

    public int getCount() {
        return this.count;
    }
 */
}

