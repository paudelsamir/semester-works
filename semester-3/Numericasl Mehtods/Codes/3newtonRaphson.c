#include <stdio.h>
#include <math.h>

#define EPSILON 0.00001 

double f(double x) {
    return x*x*x - 2*x*x + x - 3;
}

double fd(double x) {
    return 3*x*x - 4*x + 1;
}

double nr(double x0) {
    double x = x0;
    do {
        x0 = x;
        x = x0 - f(x0) / fd(x0);
    } while (fabs(f(x)) > EPSILON); 
    return x; 
}

int main() {
    double x0;
    printf("Enter initial guess (x0): ");
    scanf("%lf", &x0);

    double root = nr(x0); 
    printf("Root is approximately: %lf\n", root);
    return 0;
}
