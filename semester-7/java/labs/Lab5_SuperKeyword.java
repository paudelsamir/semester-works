public class Lab5_SuperKeyword {
    
    // Grandparent class
    static class GrandParent {
        void display() {
            System.out.println("GrandParent display method");
        }
    }
    
    // Parent class
    static class Parent extends GrandParent {
        String name = "Parent";
        
        Parent() {
            System.out.println("Parent Constructor");
        }
        
        Parent(String name) {
            this.name = name;
            System.out.println("Parent Constructor with name: " + name);
        }
        
        void display() {
            System.out.println("Parent display method - Name: " + name);
        }
    }
    
    // Child class
    static class Child extends Parent {
        String name = "Child";
        
        Child() {
            super("Parent from Child");
            System.out.println("Child Constructor");
        }
        
        // Task a: Using super to access super class constructor
        void callParentConstructor() {
            System.out.println("\nTask A: Accessing super class constructor");
            System.out.println("Child name: " + name);
            System.out.println("Parent name accessed via super: " + super.name);
        }
        
        // Task b: Using super to overcome name hiding
        void overriddenDisplay() {
            System.out.println("\nTask B: Overcoming name hiding");
            System.out.println("Child display - " + name);
            super.display();
        }
        
        void display() {
            System.out.println("Child display method - Name: " + name);
        }
    }
    
    // Multilevel Inheritance - Task c
    static class GrandChild extends Child {
        void demonstrateMultilevel() {
            System.out.println("\nTask C: Multilevel Inheritance");
            System.out.println("GrandChild accessing Parent methods through Child");
            display();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("--- Super Keyword and Multilevel Inheritance ---\n");
        
        Child child = new Child();
        child.callParentConstructor();
        child.overriddenDisplay();
        
        System.out.println("\n--- Multilevel Inheritance ---");
        GrandChild grandChild = new GrandChild();
        grandChild.demonstrateMultilevel();
        
        System.out.println("\n=============================");
        System.out.println("Lab No.: 5");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
