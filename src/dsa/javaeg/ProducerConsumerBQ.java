package dsa.javaeg;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer extends Thread {

    private final BlockingQueue<Integer> buffer;

    public Producer(BlockingQueue<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                buffer.put(i);
                System.out.println("Produced: " + i);
                Thread.sleep(1000); // Simulate time to produce item
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer extends Thread {
    private final BlockingQueue<Integer> buffer;

    public Consumer(BlockingQueue<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int item = buffer.take();
                System.out.println("Consumed: " + item);
                Thread.sleep(2000); // Simulate time to consume item
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ProducerConsumerBQ {
    public static void main(String[] args) {
        
        BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(5); // Buffer size is 5
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}
