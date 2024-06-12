#include <stdio.h>

int main()
{
    float x, ax[50], y[50], a[50], p, v;
    int n, j, i;
    printf("Enter number of data points: ");
    scanf("%d", &n);
    printf("Enter value to be interpolated: ");
    scanf("%f", &x);
    for (i = 0; i < n; i++)
    {
        printf("x[%d] = ", i);
        scanf("%f", &ax[i]);
        printf("y[%d] = ", i);
        scanf("%f", &y[i]);
        a[i] = y[i];
    }
    for (i = 0; i < n; i++)
    {
        for (j = n - 1; j > i; j--)
        {
            a[j] = (a[j] - a[j - 1]) / (ax[j] - ax[j - 1 - i]);
        }
    }
    v = 0;
    for (i = 0; i < n; i++)
    {
        p = 1;
        for (j = 0; j < i; j++)
        {
            p = p * (x - ax[j]);
        }
        v = v + a[i] * p;
    }
    printf("Interpolated value: %f\n", v);
    return 0;
}
