#include <stdio.h>

int main() {
    float lambda, mu;

    printf("Enter arrival rate (lambda), e.g., 2: ");
    scanf("%f", &lambda);

    printf("Enter service rate (mu), e.g., 3: ");
    scanf("%f", &mu);

    if (lambda >= mu) {
        printf("System unstable (lambda must be less than mu).\n");
        return 1;
    }

    float rho = lambda / mu;
    float L = rho / (1 - rho);
    float Lq = (rho * rho) / (1 - rho);
    float W = 1 / (mu - lambda);
    float Wq = rho / (mu - lambda);

    printf("\n--- Lab 10: Measure of M/M/1 Queue ---\n");
    printf("Utilization (rho): %.3f\n", rho);
    printf("Average number in system (L): %.3f\n", L);
    printf("Average number in queue (Lq): %.3f\n", Lq);
    printf("Average time in system (W): %.3f\n", W);
    printf("Average time in queue (Wq): %.3f\n", Wq);

    return 0;
}
