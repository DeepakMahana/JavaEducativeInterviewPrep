package dsa.javaeg;

import java.io.*;

class MyClass implements Serializable {
    private int value;

    public MyClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class Serialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Serialization
        MyClass obj = new MyClass(42);
        FileOutputStream fileOut = new FileOutputStream("object.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(obj);
        out.close();
        fileOut.close();

        // Deserialization
        FileInputStream fileIn = new FileInputStream("object.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        MyClass obj2 = (MyClass) in.readObject();
        in.close();
        fileIn.close();

        System.out.println("Deserialized object value: " + obj2.getValue());
    }
}

