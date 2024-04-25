package dsa.javaeg;

// Custom checked exception
class CustomCheckedException extends Exception {
    public CustomCheckedException(String message) {
        super(message);
    }
}

// Custom unchecked exception
class CustomUncheckedException extends RuntimeException {
    public CustomUncheckedException(String message) {
        super(message);
    }
}

public class CustomException {
    public static void main(String[] args) {
        try {
            // Throw custom checked exception
            throw new CustomCheckedException("This is a custom checked exception");
        } catch (CustomCheckedException e) {
            System.out.println("Caught custom checked exception: " + e.getMessage());
        }

        // Throw custom unchecked exception
        throw new CustomUncheckedException("This is a custom unchecked exception");
    }
}

