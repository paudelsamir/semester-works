interface Shape {
    double area(double x, double y);
    double perimeter(double x, double y);
}

class Rectangle implements Shape {
    public double area(double length, double breadth) {
        return length * breadth;
    }
    public double perimeter(double length, double breadth) {
        return 2 * (length + breadth);
    }
}

public class Lab11_ShapeInterface {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        System.out.println("Length: 5, Breadth: 3");
        System.out.println("Area: " + r.area(5, 3));
        System.out.println("Perimeter: " + r.perimeter(5, 3));

        System.out.println("\nLab No.: 11");
        System.out.println("Name: Shishir Pandey");
        System.out.println("Roll No./Section: 15/079, Section: A");
    }
}
