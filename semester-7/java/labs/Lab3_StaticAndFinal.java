public class Lab3_StaticAndFinal {
    
    // Static variable
    static int staticCount = 0;
    
    // Final variable
    final int finalValue = 100;
    
    // Static method
    static void displayStaticCount() {
        staticCount++;
        System.out.println("Static Count: " + staticCount);
    }
    
    // Static block
    static {
        System.out.println("--- Static Block Executed ---");
        staticCount = 10;
        System.out.println("Initial static count set to: " + staticCount);
    }
    
    // Task a: Demonstrate static variable, method, and block
    static void taskStaticDemo() {
        System.out.println("\n--- Task A: Static Variable, Method, and Block ---");
        displayStaticCount();
        displayStaticCount();
        System.out.println("Final static count: " + staticCount);
    }
    
    // Task b: Demonstrate final keyword
    static void taskFinalDemo() {
        System.out.println("\n--- Task B: Final Keyword ---");
        
        // Final variable
        final int x = 50;
        System.out.println("Final variable x: " + x);
        // x = 60;  // This would cause compilation error
        
        // Final method (cannot be overridden)
        // Cannot demonstrate in static context easily
        
        // Final class example (String is final)
        final String finalString = "This is final";
        System.out.println("Final string: " + finalString);
    }
    
    public static void main(String[] args) {
        taskStaticDemo();
        taskFinalDemo();
        
        System.out.println("\n=============================");
        System.out.println("Lab No.: 3");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
