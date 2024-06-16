#include <stdio.h>

int factorial(int n) {
    if (n == 0) return 1;
    else return n * factorial(n - 1);
}

int main() {
    int n;
    printf("Enter a number: ");
    scanf("%d", &n);
    printf("Factorial of %d is %d\n", n, factorial(n));
    return 0;
}

/*
Sample Input:
Enter a number: 5
Expected Output:
Factorial of 5 is 120
*/
