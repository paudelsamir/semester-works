#include <stdio.h>
#include <math.h>

#define EPSILON 0.00001

#define f(x) (x * x * x - 2 * x * x + x - 3)

double secant(double x1, double x2) {
    double x0;
    while (fabs(x2 - x1) > EPSILON) {
        x0 = x2 - (f(x2) * (x2 - x1)) / (f(x2) - f(x1));
        x1 = x2;
        x2 = x0;
    }
    return x2;
}

int main() {
    double x1, x2;
    printf("Enter initial two guesses [x1, x2] where the root lies: ");
    scanf("%lf %lf", &x1, &x2);

    double root = secant(x1, x2);
    if (isnan(root)) {
        printf("Roots not found in the given interval.\n");
    } else {
        printf("Root is approximately: %lf\n", root);
    }
    return 0;
}
