package dsa.javaeg;

class WorkerThread extends Thread {
    @Override
    public void run() {
        System.out.println("WorkerThread started.");
        try {
            Thread.sleep(2000); // Simulating some work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("WorkerThread finished.");
    }
}

public class JoinThread {
    public static void main(String[] args) {
        WorkerThread workerThread = new WorkerThread();
        workerThread.start();

        try {
            System.out.println("Main thread waiting for WorkerThread to finish.");
            workerThread.join(); // Main thread waits for workerThread to finish
            System.out.println("WorkerThread has finished. Main thread can proceed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
