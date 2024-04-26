package dsa.javaeg;

import java.util.concurrent.*;

public class FutureMethodsExample {

    static class MyTask implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            // Simulate a long-running computation
            Thread.sleep(2000);
            return 42; // Example result
        }
    }

    public static void main(String[] args) throws Exception {
        
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(new MyTask());

        // Check if the computation is done
        System.out.println("Is the computation done? " + future.isDone());

        // Cancel the computation
        boolean cancelled = future.cancel(true);
        if (cancelled) {
            System.out.println("Computation cancelled successfully.");
        } else {
            System.out.println("Computation cannot be cancelled or has already completed.");
        }

        // Check if the computation was cancelled
        System.out.println("Was the computation cancelled? " + future.isCancelled());

        // Check if the computation is done after cancellation
        System.out.println("Is the computation done after cancellation? " + future.isDone());

        executor.shutdown();
    }
}

