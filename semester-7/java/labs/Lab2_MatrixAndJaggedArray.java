import java.util.Scanner;

public class Lab2_MatrixAndJaggedArray {
    
    // Task a: Display matrix and diagonal elements
    static void displayMatrixAndDiagonals() {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[3][3];
        
        System.out.println("--- Task A: Matrix 3x3 and Diagonal Elements ---");
        System.out.println("Enter elements for 3x3 matrix:");
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("\nMatrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("\nMain Diagonal Elements:");
        for (int i = 0; i < 3; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        
        System.out.println("\n\nAnti-Diagonal Elements:");
        for (int i = 0; i < 3; i++) {
            System.out.print(matrix[i][2 - i] + " ");
        }
        System.out.println();
    }
    
    // Task b: Demonstrate jagged array
    static void demonstrateJaggedArray() {
        System.out.println("\n--- Task B: Jagged Array ---");
        
        // Create jagged array
        int[][] jaggedArray = {
            {1, 2, 3},
            {4, 5},
            {6, 7, 8, 9},
            {10}
        };
        
        System.out.println("Jagged Array elements:");
        for (int i = 0; i < jaggedArray.length; i++) {
            System.out.print("Row " + i + ": ");
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        displayMatrixAndDiagonals();
        demonstrateJaggedArray();
        
        System.out.println("\n=============================");
        System.out.println("Lab No.: 2");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
