public class Lab6_MethodOverriding {
    
    // Task a: Method Overriding
    static class Shape {
        void draw() {
            System.out.println("Drawing a shape");
        }
    }
    
    static class Circle extends Shape {
        @Override
        void draw() {
            System.out.println("Drawing a Circle");
        }
        
        double getArea(double radius) {
            return Math.PI * radius * radius;
        }
    }
    
    static class Rectangle extends Shape {
        @Override
        void draw() {
            System.out.println("Drawing a Rectangle");
        }
        
        double getArea(double length, double width) {
            return length * width;
        }
    }
    
    static class Triangle extends Shape {
        @Override
        void draw() {
            System.out.println("Drawing a Triangle");
        }
        
        double getArea(double base, double height) {
            return 0.5 * base * height;
        }
    }
    
    // Task b: Runtime Polymorphism
    static void demonstratePolymorphism() {
        System.out.println("\n--- Task B: Runtime Polymorphism (Area of Figures) ---\n");
        
        Shape shape1 = new Circle();
        Shape shape2 = new Rectangle();
        Shape shape3 = new Triangle();
        
        System.out.println("Method Overriding:");
        shape1.draw();
        shape2.draw();
        shape3.draw();
        
        System.out.println("\nCalculating Areas using Runtime Polymorphism:");
        
        Circle circle = (Circle) shape1;
        System.out.println("Circle area (radius=5): " + circle.getArea(5));
        
        Rectangle rect = (Rectangle) shape2;
        System.out.println("Rectangle area (length=10, width=5): " + rect.getArea(10, 5));
        
        Triangle tri = (Triangle) shape3;
        System.out.println("Triangle area (base=10, height=6): " + tri.getArea(10, 6));
    }
    
    public static void main(String[] args) {
        System.out.println("--- Method Overriding and Polymorphism ---");
        
        // Task a: Method Overriding
        System.out.println("\nTask A: Method Overriding");
        Circle c = new Circle();
        Rectangle r = new Rectangle();
        Triangle t = new Triangle();
        
        c.draw();
        r.draw();
        t.draw();
        
        demonstratePolymorphism();
        
        System.out.println("\n=============================");
        System.out.println("Lab No.: 6");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
