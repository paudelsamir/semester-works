public class Lab1_BoxClass {
    
    static class Box {
        double length;
        double breadth;
        double height;
        
        // Method to print the values of variables
        void printValues() {
            System.out.println("Length: " + length);
            System.out.println("Breadth: " + breadth);
            System.out.println("Height: " + height);
        }
        
        // Method to print the volume of box
        void printVolume() {
            double volume = length * breadth * height;
            System.out.println("Volume of Box: " + volume);
        }
    }
    
    public static void main(String[] args) {
        // Create first object
        Box box1 = new Box();
        box1.length = 5.0;
        box1.breadth = 4.0;
        box1.height = 3.0;
        
        System.out.println("--- Box 1 ---");
        box1.printValues();
        box1.printVolume();
        
        // Create second object
        Box box2 = new Box();
        box2.length = 10.0;
        box2.breadth = 8.0;
        box2.height = 6.0;
        
        System.out.println("\n--- Box 2 ---");
        box2.printValues();
        box2.printVolume();
        
        // Print lab information
        System.out.println("\n=============================");
        System.out.println("Lab No.: 1");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
