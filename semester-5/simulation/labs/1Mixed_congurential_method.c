#include <stdio.h>

int main() {
    int X0 = 11;
    int m = 100;
    int a = 5;
    int c = 13;
    int n = 50;
    int Xi = X0;

    printf("Lab 1: Mixed Congruential Method\n");
    printf("Random numbers generated using Mixed Congruential Method:\n");
    for (int i = 0; i < n; i++) {
        Xi = (a * Xi + c) % m;
        printf("%d, ", Xi);
    }

    return 0;
}