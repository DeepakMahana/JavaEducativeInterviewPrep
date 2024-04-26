package dsa.javaeg.design;

class Singleton {
    // Private static instance variable
    private static Singleton instance;

    // Private constructor to prevent instantiation from outside
    private Singleton() {}

    // Public static method to get the instance
    public static Singleton getInstance() {
        // Lazy initialization
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Example method
    public void showMessage() {
        System.out.println("Hello, I am a Singleton instance!");
    }
}

// Example usage
public class SingletonExample {
    public static void main(String[] args) {
        // Get the Singleton instance
        Singleton singleton = Singleton.getInstance();
        // Use the instance
        singleton.showMessage();
    }
}
