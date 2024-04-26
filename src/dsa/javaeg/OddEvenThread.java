package dsa.javaeg;

class Printer {

    private int number = 1;
    private final int limit;

    public Printer(int limit) {
        this.limit = limit;
    }

    public synchronized void printEven() {
        try {
            while (number <= limit) {
                if (number % 2 == 0) {
                    System.out.println("Even Thread: " + number);
                    number++;
                    notify();
                } else {
                    wait();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void printOdd() {
        try {
            while (number <= limit) {
                if (number % 2 != 0) {
                    System.out.println("Odd Thread: " + number);
                    number++;
                    notify();
                } else {
                    wait();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class OddEvenThread {
    public static void main(String[] args) {
        Printer printer = new Printer(10);
        Thread evenThread = new Thread(printer::printEven);
        Thread oddThread = new Thread(printer::printOdd);

        evenThread.start();
        oddThread.start();
    }
}
