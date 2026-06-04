public class Lab4_StudentHierarchy {
    
    // Student class
    static class Student {
        protected int roll_no;
        
        void readRollNo(int roll) {
            this.roll_no = roll;
        }
        
        void displayRollNo() {
            System.out.println("Roll No: " + roll_no);
        }
    }
    
    // Test class inherits Student
    static class Test extends Student {
        protected int marks1;
        protected int marks2;
        
        void readMarks(int m1, int m2) {
            this.marks1 = m1;
            this.marks2 = m2;
        }
        
        void displayMarks() {
            System.out.println("Marks 1: " + marks1);
            System.out.println("Marks 2: " + marks2);
        }
    }
    
    // Result class inherits Test
    static class Result extends Test {
        int total;
        
        void calculateTotal() {
            this.total = marks1 + marks2;
        }
        
        void displayTotal() {
            System.out.println("Total Marks: " + total);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("--- Inheritance Demonstration ---\n");
        
        Result result = new Result();
        
        // Read and display roll no
        result.readRollNo(114);
        System.out.println("Student Information:");
        result.displayRollNo();
        
        // Read and display marks
        result.readMarks(85, 90);
        result.displayMarks();
        
        // Calculate and display total
        result.calculateTotal();
        result.displayTotal();
        
        System.out.println("\n=============================");
        System.out.println("Lab No.: 4");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
