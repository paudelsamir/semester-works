#include <stdio.h>
#include <math.h>

float f(float x) {
    return x * x;
}
float trapezoidal_rule(float a, float b, int n) {
    float h = (b - a) / n;
    float sum = 0.5 * (f(a) + f(b));
    for (int i = 1; i < n; ++i) {
        sum += f(a + i * h);
    }
    return h * sum;
}

int main() {
    float lower_limit, upper_limit;
    int num_intervals;

    printf("Enter the lower limit of integration: ");
    scanf("%f", &lower_limit);

    printf("Enter the upper limit of integration: ");
    scanf("%f", &upper_limit);

    printf("Enter the number of intervals: ");
    scanf("%d", &num_intervals);

    if (num_intervals <= 0) {
        printf("Number of intervals must be positive.\n");
        return 1; 
    }
    float result = trapezoidal_rule(lower_limit, upper_limit, num_intervals);
    printf("Approximate integral using trapezoidal rule: %f\n", result);

    return 0;
}
