#include <stdio.h>
#include <math.h>

int main() {
    int n;
    float t_value;

    printf("Lab 6: Confidence Interval Calculation\n"); // Added lab number at the top

    printf("Enter sample size (e.g., 5): ");
    scanf("%d", &n);

    float sample[n];
    printf("Enter %d sample values:\n", n);
    for (int i = 0; i < n; i++) {
        scanf("%f", &sample[i]);
    }

    printf("Enter t-value for confidence level (e.g., 2.776 for 95%% when n=5): ");
    scanf("%f", &t_value);

    float sum = 0;
    for (int i = 0; i < n; i++) sum += sample[i];
    float mean = sum / n;

    float variance = 0;
    for (int i = 0; i < n; i++)
        variance += (sample[i] - mean) * (sample[i] - mean);
    variance /= (n - 1);

    float stddev = sqrt(variance);
    float margin = t_value * (stddev / sqrt(n));

    printf("\nConfidence Interval: %.2f ± %.2f\n", mean, margin);
    printf("Which means (%.2f , %.2f)\n", mean - margin, mean + margin);

    return 0;
}
