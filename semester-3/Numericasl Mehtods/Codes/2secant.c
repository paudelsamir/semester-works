#include <stdio.h>
#include <math.h>

#define EPSILON 0.00001

#define f(x) (x * x * x - 2 * x * x + x - 3)

double secant(double x0, double x1) {
    double x2;
    while (fabs(x1 - x0) > EPSILON) {
        x2 = x1 - (f(x1) * (x1 - x0)) / (f(x1) - f(x0));
        x0 = x1;
        x1 = x2;
    }
    return x1;
}

int main() {
    double x0, x1;
    printf("Enter initial two guesses [x0, x1] where the root lies: ");
    scanf("%lf %lf", &x0, &x1);

    double root = secant(x0, x1);
    if (isnan(root)) {
        printf("Roots not found in the given interval.\n");
    } else {
        printf("Root is approximately: %lf\n", root);
    }
    return 0;
}
