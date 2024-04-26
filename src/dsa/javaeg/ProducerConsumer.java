package dsa.javaeg;

import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer {
    
    private final Queue<Integer> buffer;
    private final int capacity;

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new LinkedList<>();
    }

    public synchronized void produce(int item) throws InterruptedException {
        while (buffer.size() == capacity) {
            // Buffer is full, wait for consumer to consume
            wait();
        }
        buffer.offer(item);
        System.out.println("Produced: " + item);
        notifyAll(); // Notify waiting consumers
    }

    public synchronized int consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            // Buffer is empty, wait for producer to produce
            wait();
        }
        int item = buffer.poll();
        System.out.println("Consumed: " + item);
        notifyAll(); // Notify waiting producers
        return item;
    }
}

class Producer extends Thread {
    private final SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                buffer.produce(i);
                Thread.sleep(1000); // Simulate time to produce item
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer extends Thread {
    private final SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                buffer.consume();
                Thread.sleep(2000); // Simulate time to consume item
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(5); // Buffer size is 5
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}
