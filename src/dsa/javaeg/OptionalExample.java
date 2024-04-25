package dsa.javaeg;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        
        Optional<String> optionalString = Optional.of("Hello");

        // Check if a value is present
        if (optionalString.isPresent()) {
            System.out.println("Value is present: " + optionalString.get());
        } else {
            System.out.println("Value is absent.");
        }

        // Using ifPresent to perform an action if a value is present
        optionalString.ifPresent(value -> System.out.println("Value is present: " + value));

        // Getting the value or a default value if absent
        String result = optionalString.orElse("Default Value");
        System.out.println("Result: " + result);
    }
}

