#include <stdio.h>

int main() {
    int X0 = 13;
    int m = 1000;
    int a = 15;
    int c = 7; // Not used in pure multiplicative method
    int n = 50;
    int Xi = X0;

    printf("Lab 2: Multiplicative Congruential Method\n");
    printf("Random numbers generated using Multiplicative Congruential Method:\n");
    for (int i = 0; i < n; i++) {
        Xi = (a * Xi) % m;
        printf("%d, ", Xi);
    }

    return 0;
}