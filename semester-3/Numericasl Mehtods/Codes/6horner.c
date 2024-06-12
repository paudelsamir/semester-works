#include <stdio.h>
#include <math.h>

#define EPS 0.00001

void horner(int n, float a[], float x0, float p[]) {
    int i;
    p[0] = a[n];
    for (i = n - 1; i >= 0; i--) {
        p[0] = a[i] + p[0] * x0;
    }
}

int main(void) {
    float a[10], p[2], x0, x1;
    int i, n, count = 0;

    printf("Enter the degree of the polynomial: ");
    scanf("%d", &n);
    printf("Enter the coefficients of the polynomial starting from the highest degree: ");
    for (i = n; i >= 0; i--) {
        scanf("%f", &a[i]);
    }
    printf("Enter a valid initial point x0: ");
    scanf("%f", &x0);

    horner(n, a, x0, p);

    while (1) {
        horner(n, a, x0, p);
        if (fabs(p[1]) < EPS) {
            printf("Derivative at current point is zero. Exiting...\n");
            return 1;
        }
        x1 = x0 - (p[0] / p[1]);
        count++;
        if (fabs((x1 - x0) / x1) <= EPS)
            break;
        x0 = x1;
    }
    printf("The approximate root of given function %f with %d number of iterations.\n", x1, count);
    return 0;
}
