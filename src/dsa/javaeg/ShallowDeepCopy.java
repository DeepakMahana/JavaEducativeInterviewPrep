package dsa.javaeg;

class Address {
    String city;

    Address(String city) {
        this.city = city;
    }
}

class Person {
    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}

public class ShallowDeepCopy {
    public static void main(String[] args) {
        Address originalAddress = new Address("New York");
        Person originalPerson = new Person("John", originalAddress);

        // Shallow copy
        Person shallowCopy = new Person(originalPerson.name, originalPerson.address);

        // Deep copy
        Address deepCopiedAddress = new Address(originalPerson.address.city);
        Person deepCopy = new Person(originalPerson.name, deepCopiedAddress);

        // Modify the original address
        originalPerson.address.city = "San Francisco";

        System.out.println("Shallow copy address: " + shallowCopy.address.city); // Output: San Francisco
        System.out.println("Deep copy address: " + deepCopy.address.city); // Output: New York
    }
}

