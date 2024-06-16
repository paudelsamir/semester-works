#include <stdio.h>

// Function to calculate factorial using recursion
int factorial(int n) {
    if (n == 0)
        return 1;
    else
        return n * factorial(n - 1);
}

int main() {
    int n;
    
    // User input
    printf("Enter an integer: ");
    scanf("%d", &n);
    
    printf("Factorial of %d is %d\n", n, factorial(n));
    return 0;
}

/*
Sample Input:
Enter an integer: 5

Expected Output:
Factorial of 5 is 120
*/
