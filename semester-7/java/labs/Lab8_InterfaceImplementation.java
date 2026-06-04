public class Lab8_InterfaceImplementation {
    
    // Interface Shape
    interface Shape {
        double area(double x, double y);
        double perimeter(double x, double y);
    }
    
    // Rectangle class implementing Shape interface
    static class Rectangle implements Shape {
        double length;
        double width;
        
        // Constructor
        Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }
        
        @Override
        public double area(double x, double y) {
            length = x;
            width = y;
            return length * width;
        }
        
        @Override
        public double perimeter(double x, double y) {
            length = x;
            width = y;
            return 2 * (length + width);
        }
        
        void displayDimensions() {
            System.out.println("Rectangle Dimensions:");
            System.out.println("Length: " + length);
            System.out.println("Width: " + width);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("--- Interface Implementation ---\n");
        
        // Create instance of Rectangle
        Rectangle rectangle = new Rectangle(5.0, 4.0);
        
        rectangle.displayDimensions();
        
        // Calculate and display area
        double area = rectangle.area(5.0, 4.0);
        System.out.println("Area: " + area);
        
        // Calculate and display perimeter
        double perimeter = rectangle.perimeter(5.0, 4.0);
        System.out.println("Perimeter: " + perimeter);
        
        // Using interface reference
        Shape shape = new Rectangle(8.0, 6.0);
        System.out.println("\nUsing Shape interface reference:");
        System.out.println("Area: " + shape.area(8.0, 6.0));
        System.out.println("Perimeter: " + shape.perimeter(8.0, 6.0));
        
        System.out.println("\n=============================");
        System.out.println("Lab No.: 8");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
