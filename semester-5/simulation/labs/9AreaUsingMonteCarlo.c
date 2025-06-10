#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

int main() {
    int n, count = 0;
    float x, y;

    printf("Lab 9: Area Estimation Using Monte Carlo Method\n"); // Added lab number
    printf("Enter number of random points (e.g., 10000): ");
    scanf("%d", &n);

    srand(time(NULL));

    for (int i = 0; i < n; i++) {
        x = ((float)rand() / RAND_MAX) * M_PI;  // x in [0, pi]
        y = (float)rand() / RAND_MAX;            // y in [0, 1]

        if (y <= sin(x))
            count++;
    }

    float area = ((float)count / n) * M_PI;

    printf("\nEstimated area under sin(x) from 0 to pi = %.6f\n", area);

    return 0;
}
