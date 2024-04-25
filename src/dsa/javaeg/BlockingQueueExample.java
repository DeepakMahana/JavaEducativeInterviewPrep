package dsa.javaeg;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) {
        // Creating a bounded blocking queue with a capacity of 3
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Producer is producing item: " + i);
                    queue.put(i); // Put item into the queue (blocking if full)
                    Thread.sleep(1000); // Simulate some work
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    int item = queue.take(); // Take item from the queue (blocking if empty)
                    System.out.println("Consumer is consuming item: " + item);
                    Thread.sleep(2000); // Simulate some work
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Starting the producer and consumer threads
        producer.start();
        consumer.start();
    }
}

