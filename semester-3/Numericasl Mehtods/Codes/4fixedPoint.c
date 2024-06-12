#include<stdio.h>
#include<math.h>

#define g(x) 2/(1+x)

int main() {
    float x0, x1, e, error;
    int i = 0;

    printf("f(x) = x^2 + x - 2 = 0\n");
    printf("x = 2/(1 + x) = g(x)\n");
    printf("Enter initial guess: ");
    scanf("%f", &x0);
    printf("Enter error precision: ");
    scanf("%f", &error);

    printf("\nSteps \t x0 \t x1=g(x) \t Error\n");
    do {
        x1 = g(x0);
        e = fabs((x1 - x0) / x1);
        i++;
        printf("%d \t %.6f \t %.6f \t %.6f\n", i, x0, x1, e);
        x0 = x1;
    } while (e > error);

    printf("\nRoot is: %.6f\n", x1);
    return 0;
}
