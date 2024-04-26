package dsa.javaeg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {

    private final int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " is running on thread: " + Thread.currentThread().getName());
        // Simulate some task execution
        try {
            Thread.sleep(2000); // Simulate task execution time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Task " + taskId + " is completed.");
    }
}

public class ExecutorThreadPoolExample {
    public static void main(String[] args) {
        
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit tasks to the thread pool
        for (int i = 1; i <= 5; i++) {
            Task task = new Task(i);
            executor.submit(task);
        }

        // Shutdown the executor after all tasks are completed
        executor.shutdown();
    }
}
