#include <stdio.h>

int main() {
    int n, r;
    printf("Lab 4A: Autocorrelation Test\n"); // Added lab number at the top
    printf("Enter number of random numbers (e.g., 10): ");
    scanf("%d", &n);

    float X[n];
    printf("Enter %d random numbers (0 to 1):\n", n);
    for (int i = 0; i < n; i++) scanf("%f", &X[i]);

    printf("Enter lag value r (e.g., 1 or 2): ");
    scanf("%d", &r);

    float mean = 0;
    for (int i = 0; i < n; i++) mean += X[i];
    mean /= n;

    float num = 0, den = 0;
    for (int i = 0; i < n - r; i++)
        num += (X[i] - mean) * (X[i + r] - mean);

    for (int i = 0; i < n; i++)
        den += (X[i] - mean) * (X[i] - mean);

    float autocorr = num / den;

    printf("\nAutocorrelation Coefficient (lag %d): %.4f\n", r, autocorr);

    return 0;
}
