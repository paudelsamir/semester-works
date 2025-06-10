#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
    printf("Lab 3a - Kolmogorov-Smirnov Test\n"); // Added lab number at the top

    int n;
    printf("Enter the number of data points: ");
    scanf("%d", &n);

    float *data = (float *)malloc(n * sizeof(float));
    if (data == NULL) {
        printf("Memory allocation failed.\n");
        return 1;
    }

    printf("Enter %d data values (between 0 and 1):\n", n);
    for (int i = 0; i < n; i++) {
        scanf("%f", &data[i]);
    }

    float D = 0, D_plus, D_minus;
    for (int i = 0; i < n; i++) {
        D_plus = fabs(((float)(i + 1) / n) - data[i]);
        D_minus = fabs(data[i] - ((float)i / n));
        if (D_plus > D) D = D_plus;
        if (D_minus > D) D = D_minus;
    }

    printf("Kolmogorov-Smirnov Test Statistic D = %.4f\n", D);

    free(data);
    return 0;
}
