#include <stdio.h>
#include <math.h>
#include <stdlib.h>

int main() {
    int n, k;
    printf("Lab 3b: Chi-Square Test\n"); // Added lab number at the top

    printf("Enter number of data points (n): ");
    scanf("%d", &n);

    float *data = (float *)malloc(n * sizeof(float));
    if (data == NULL) {
        printf("Memory allocation failed for data.\n");
        return 1;
    }
    printf("Enter %d data points (between 0 and 1):\n", n);
    for (int i = 0; i < n; i++) {
        scanf("%f", &data[i]);
    }

    printf("Enter number of bins (k): ");
    scanf("%d", &k);

    int *obs = (int *)malloc(k * sizeof(int));
    if (obs == NULL) {
        printf("Memory allocation failed for obs.\n");
        free(data);
        return 1;
    }
    for (int i = 0; i < k; i++) obs[i] = 0;
    float expected = (float)n / k;
    float chi = 0;

    // Count observations per bin
    for (int i = 0; i < n; i++) {
        int index = (int)(data[i] * k);
        if (index == k) index = k - 1; // Handle edge case when data[i] == 1.0
        obs[index]++;
    }

    // Chi-Square calculation
    for (int i = 0; i < k; i++) {
        chi += pow(obs[i] - expected, 2) / expected;
    }

    printf("Chi-Square Test Statistic = %.4f\n", chi);
    free(data);
    free(obs);
    return 0;
}
