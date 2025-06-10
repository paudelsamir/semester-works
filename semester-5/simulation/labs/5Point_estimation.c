#include <stdio.h>
#include <stdlib.h>

int main() {
    int n;
    float population_mean;

    printf("Lab 5: Point Estimation\n"); // Added lab number at the top

    printf("Enter sample size (e.g., 5): ");
    scanf("%d", &n);

    float *sample = (float *)malloc(n * sizeof(float));
    if (sample == NULL) {
        printf("Memory allocation failed.\n");
        return 1;
    }
    printf("Enter %d sample values (e.g., 12.3 14.6 ...):\n", n);
    for (int i = 0; i < n; i++) {
        scanf("%f", &sample[i]);
    }

    printf("Enter population mean (e.g., 15.0): ");
    scanf("%f", &population_mean);

    float sum = 0;
    for (int i = 0; i < n; i++) sum += sample[i];

    float sample_mean = sum / n;
    float bias = sample_mean - population_mean;

    printf("Bias: %.2f\n", bias);

    free(sample);
    return 0;
}
