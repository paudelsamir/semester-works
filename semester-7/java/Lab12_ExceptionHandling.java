import java.io.IOException;

public class Lab12_ExceptionHandling {

    static class CustomException extends Exception {
        CustomException(String message) {
            super(message);
        }
    }

    static void taskTryCatchFinally() {
        System.out.println("\nTask A: Try, Catch, Finally Blocks");
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed");
        }
    }

    static void taskMultipleCatch() {
        System.out.println("\nTask B: Multiple Catch Blocks");
        try {
            String str = "Hello";
            int num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }

    static void taskNestedTry() {
        System.out.println("\nTask C: Nested Try Statements");
        try {
            try {
                int[] arr = {1, 2, 3};
                System.out.println(arr[5]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner catch: ArrayIndexOutOfBoundsException");
                throw new Exception("Re-throwing from inner catch");
            }
        } catch (Exception e) {
            System.out.println("Outer catch: " + e.getMessage());
        }
    }

    static void taskThrow() {
        System.out.println("\nTask D: Using throw keyword");
        try {
            throw new ArithmeticException("Manually thrown arithmetic exception");
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }

    static void methodWithThrows() throws IOException {
        throw new IOException("IOException thrown via throws clause");
    }

    static void taskThrows() {
        System.out.println("\nTask E: Using throws keyword");
        try {
            methodWithThrows();
        } catch (IOException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }

    static void taskCustomException() {
        System.out.println("\nTask F: Custom Exception");
        try {
            int age = -5;
            if (age < 0) {
                throw new CustomException("Age cannot be negative");
            }
        } catch (CustomException e) {
            System.out.println("Caught CustomException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Exception Handling Demonstration ---");

        taskTryCatchFinally();
        taskMultipleCatch();
        taskNestedTry();
        taskThrow();
        taskThrows();
        taskCustomException();

        System.out.println("\nLab No.: 12");
        System.out.println("Name: Shishir Pandey");
        System.out.println("Roll No./Section: 15/079, Section: A");
    }
}
