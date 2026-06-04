public class Lab7_NestedClasses {
    
    // Task a: Static Nested Class
    static class StaticNestedClass {
        static int staticVar = 10;
        
        static void staticMethod() {
            System.out.println("Static Nested Class - Static Method");
            System.out.println("Static Variable: " + staticVar);
        }
        
        void instanceMethod() {
            System.out.println("Static Nested Class - Instance Method");
        }
    }
    
    // Task b: Non-static Nested Class (Inner Class)
    class InnerClass {
        int innerVar = 20;
        
        void innerMethod() {
            System.out.println("Inner Class - Instance Method");
            System.out.println("Inner Variable: " + innerVar);
            System.out.println("Accessing outer class variable");
        }
    }
    
    // Task c: Local Inner Class
    void demonstrateLocalInnerClass() {
        final int localVar = 30;
        
        class LocalInnerClass {
            void display() {
                System.out.println("Local Inner Class - Method");
                System.out.println("Local Variable: " + localVar);
            }
        }
        
        LocalInnerClass local = new LocalInnerClass();
        local.display();
    }
    
    public static void main(String[] args) {
        System.out.println("--- Nested Classes Demonstration ---\n");
        
        // Task a: Static Nested Class
        System.out.println("Task A: Static Nested Class");
        StaticNestedClass.staticMethod();
        StaticNestedClass nested = new StaticNestedClass();
        nested.instanceMethod();
        
        // Task b: Non-static Nested Class (Inner Class)
        System.out.println("\nTask B: Non-static Nested Class (Inner Class)");
        Lab7_NestedClasses outer = new Lab7_NestedClasses();
        InnerClass inner = outer.new InnerClass();
        inner.innerMethod();
        
        // Task c: Local Inner Class
        System.out.println("\nTask C: Local Inner Class");
        outer.demonstrateLocalInnerClass();
        
        System.out.println("\n=============================");
        System.out.println("Lab No.: 7");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
