package dsa.javaeg;

public class BasicLambda {
    public static void main(String[] args) {
        // Lambda expression to implement the Runnable interface
        Runnable runnable = () -> System.out.println("Hello, Lambda!");
        runnable.run();
        
        // Lambda expression with parameters and body
        Calculator add = (a, b) -> a + b;
        System.out.println("3 + 5 = " + add.calculate(3, 5));
    }
}

// Functional interface with a single abstract method
interface Calculator {
    int calculate(int a, int b);
}
