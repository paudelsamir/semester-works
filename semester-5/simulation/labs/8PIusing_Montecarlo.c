#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>

int main() {
    int n, count = 0;
    float x, y;

    printf("Lab 8: Monte Carlo Estimation of PI\n"); // Added lab number at the top
    printf("Enter number of random points (e.g., 10000): ");
    scanf("%d", &n);

    srand(time(NULL));

    for (int i = 0; i < n; i++) {
        x = (float)rand() / RAND_MAX;
        y = (float)rand() / RAND_MAX;

        if (x*x + y*y <= 1.0)
            count++;
    }

    float pi_estimate = 4.0 * count / n;
    printf("\nEstimated value of PI = %.6f\n", pi_estimate);

    return 0;
}
