package dsa.javaeg;

import java.lang.reflect.*;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {

        // Inspecting classes
        Class<?> clazz = MyClass.class;

        // Get the name of the class
        System.out.println("Class Name: " + clazz.getName());

        // Get the modifiers of the class
        int modifiers = clazz.getModifiers();
        System.out.println("Modifiers: " + Modifier.toString(modifiers));

        // Get the fields of the class
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("Fields:");
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        // Get the methods of the class
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("Methods:");
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        // Get the constructors of the class
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        System.out.println("Constructors:");
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }

        // Accessing fields and methods
        @SuppressWarnings("deprecation")
        Object obj = clazz.newInstance();

        // Accessing a private field
        Field privateField = clazz.getDeclaredField("myPrivateField");
        privateField.setAccessible(true);
        privateField.set(obj, "New Value");
        System.out.println("Updated Field Value: " + privateField.get(obj));

        // Invoking a private method
        Method privateMethod = clazz.getDeclaredMethod("myPrivateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(obj);

        // Creating instances dynamically
        MyClass instance = (MyClass) clazz.newInstance();
        System.out.println("New Instance Created: " + instance);

        // Invocation of methods
        Method method = clazz.getDeclaredMethod("myMethod", String.class);
        method.invoke(obj, "Hello");
    }
}

class MyClass {
    
    private String myPrivateField = "Initial Value";

    private void myPrivateMethod() {
        System.out.println("Private Method Invoked");
    }

    public void myMethod(String message) {
        System.out.println("Message: " + message);
    }
}
