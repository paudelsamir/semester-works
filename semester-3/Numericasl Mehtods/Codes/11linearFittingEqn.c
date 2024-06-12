#include <stdio.h>
#include <math.h>
#define MAX 10

int main()
{
    int n;
    float x[MAX], y[MAX];
    float sumx = 0.0, sumy = 0.0, sumxx = 0.0, sumxy = 0.0, xmean, ymean, denom, a, b;
    
    printf("\nInput the number of data points: ");
    scanf("%d", &n);

    printf("\nInput x and y values (give gap): ");
    for (int i = 0; i < n; i++)
    {
        scanf("%f %f", &x[i], &y[i]);
    }

    for (int i = 0; i < n; i++)
    {
        sumx += x[i];
        sumy += y[i];
        sumxx += x[i] * x[i];
        sumxy += x[i] * y[i];
    }
    xmean = sumx / n;
    ymean = sumy / n;
    denom = n * sumxx - sumx * sumx;
    b = (n * sumxy - sumx * sumy) / denom;
    a = ymean - b * xmean;

    printf("\nThe line that is fit to the given data is y = %f + %fx.\n", a, b);
    return 0;
}
