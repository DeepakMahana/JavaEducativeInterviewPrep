package dsa.javaeg;

import java.util.concurrent.*;

public class FutureVsCompletableFutureExample {

    static class MyTask implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            // Simulate a long-running computation
            Thread.sleep(2000);
            return 42; // Example result
        }
    }

    public static void main(String[] args) throws Exception {
        
        // Using Future
        System.out.println("Using Future:");
        ExecutorService executor1 = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor1.submit(new MyTask());

        // Do other work while the task is running asynchronously

        // Retrieve the result (blocking)
        Integer result = future.get();
        System.out.println("Result: " + result);

        executor1.shutdown();

        // Using CompletableFuture
        System.out.println("\nUsing CompletableFuture:");
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running computation
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 42; // Example result
        });

        // Do other work while the task is running asynchronously

        // Retrieve the result (asynchronously)
        completableFuture.thenAcceptAsync(r -> System.out.println("Result: " + r));

        // Wait for the future to complete (blocking)
        completableFuture.join();
    }
}
