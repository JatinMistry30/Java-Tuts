import java.util.ArrayList;
import java.util.Scanner;

abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    // Abstract methods to be implemented by all shapes
    public abstract double calculateArea();

    public abstract double calculatePerimeter();

    public void displayDetails() {
        System.out.println("Shape: " + name);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super("Circle"); // call parent constructor
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    private double length, width;

    public Rectangle(double length, double width) {
        super("Rectangle");
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

class Triangle extends Shape {
    private double a, b, c; // sides

    public Triangle(double a, double b, double c) {
        super("Triangle");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calculateArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }
}

public class ShapeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Shape> shapes = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n===== Shape Calculator =====");
            System.out.println("1. Add Circle");
            System.out.println("2. Add Rectangle");
            System.out.println("3. Add Triangle");
            System.out.println("4. Display All Shapes");
            System.out.println("5. Calculate Total Area and Perimeter");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter radius: ");
                    double r = sc.nextDouble();
                    shapes.add(new Circle(r)); // Parent reference to child object
                    break;

                case 2:
                    System.out.print("Enter length: ");
                    double l = sc.nextDouble();
                    System.out.print("Enter width: ");
                    double w = sc.nextDouble();
                    shapes.add(new Rectangle(l, w));
                    break;

                case 3:
                    System.out.print("Enter side a: ");
                    double a = sc.nextDouble();
                    System.out.print("Enter side b: ");
                    double b = sc.nextDouble();
                    System.out.print("Enter side c: ");
                    double c = sc.nextDouble();
                    shapes.add(new Triangle(a, b, c));
                    break;

                case 4:
                    System.out.println("\n=== Shape Details ===");
                    for (Shape s : shapes) {
                        s.displayDetails(); // Runtime Polymorphism here!
                        System.out.println("----------------------");
                    }
                    break;

                case 5:
                    double totalArea = 0, totalPerimeter = 0;
                    for (Shape s : shapes) {
                        totalArea += s.calculateArea();
                        totalPerimeter += s.calculatePerimeter();
                    }
                    System.out.println("\nTotal Area of All Shapes: " + totalArea);
                    System.out.println("Total Perimeter of All Shapes: " + totalPerimeter);
                    break;

                case 6:
                    System.out.println("Exiting Shape Calculator...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);

        sc.close();
    }
}
