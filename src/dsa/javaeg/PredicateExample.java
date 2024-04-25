package dsa.javaeg;

import java.util.function.Predicate;
import java.util.function.BiPredicate;

public class PredicateExample {
    public static void main(String[] args) {
        
        // Predicate example
        Predicate<Integer> isEven = n -> n % 2 == 0;

        System.out.println("Predicate Example:");
        System.out.println("Is 4 even? " + isEven.test(4)); // Prints true
        System.out.println("Is 5 even? " + isEven.test(5)); // Prints false

        // BiPredicate example
        BiPredicate<Integer, Integer> isSumGreaterThanTen = (a, b) -> (a + b) > 10;

        System.out.println("\nBiPredicate Example:");
        System.out.println("Is the sum of 4 and 6 greater than 10? " + isSumGreaterThanTen.test(4, 6)); // Prints true
        System.out.println("Is the sum of 2 and 3 greater than 10? " + isSumGreaterThanTen.test(2, 3)); // Prints false
    }
}
