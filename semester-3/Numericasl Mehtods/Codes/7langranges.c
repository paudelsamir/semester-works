#include<stdio.h>

int main() {
    float ax[100], f[100], x, v = 0, l;
    int i, j, n;
    printf("Enter number of data: ");
    scanf("%d", &n);
    printf("Enter data:\n");
    for (i = 1; i <= n; i++) {
        printf("x[%d] = ", i);
        scanf("%f", &ax[i]);
        printf("y[%d] = ", i);
        scanf("%f", &f[i]);
    }
    printf("Enter interpolation point: ");
    scanf("%f", &x);
    for (i = 1; i <= n; i++) {
        l = 1;
        for (j = 1; j <= n; j++) {
            if (i != j) {
                l = l * (x - ax[j]) / (ax[i] - ax[j]);
            }
        }
        v = v + f[i] * l;
    }
    printf("Interpolated value at %f is %f.\n", x, v);
    return 0;
}
