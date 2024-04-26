package dsa.javaeg.design;

// Product interface
interface Shape {
    void draw();
}

// Concrete products
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

// Factory class
class ShapeFactory {
    // Method to get shape object
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        return null;
    }
}

// Example usage
public class FactoryPatternExample {
    public static void main(String[] args) {
        
        ShapeFactory shapeFactory = new ShapeFactory();

        // Get an object of Circle and call its draw method
        Shape circle = shapeFactory.getShape("CIRCLE");
        circle.draw();

        // Get an object of Rectangle and call its draw method
        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        rectangle.draw();
    }
}
