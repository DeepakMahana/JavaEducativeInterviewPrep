package dsa.javaeg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// A class representing a student
class Student implements Comparable<Student> {
    
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Implementing Comparable interface to define natural ordering based on age
    @Override
    public int compareTo(Student other) {
        return this.age - other.age;
    }

    // Override toString() for easy printing
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age + "}";
    }
}

// A custom comparator to sort students by their names
class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}

public class Compare {
    public static void main(String[] args) {
        // Creating a list of students
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", 20));
        students.add(new Student(2, "Bob", 22));
        students.add(new Student(3, "Charlie", 21));

        // Sorting using Comparable (natural ordering based on age)
        Collections.sort(students);
        System.out.println("Sorted by age (using Comparable):");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println();

        // Sorting using Comparator (sorting by name)
        Collections.sort(students, new NameComparator());
        System.out.println("Sorted by name (using Comparator):");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

