#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
    int days, state;
    float t[2][2] = {{0.8, 0.2}, {0.4, 0.6}};
    printf("Lab 7: Markov Chain Weather Simulation\nEnter days: ");
    scanf("%d", &days);
    printf("Enter weather (0=Sunny, 1=Rainy): ");
    scanf("%d", &state);
    srand(time(NULL));
    printf("\nDay 0: %s\n", state ? "Rainy" : "Sunny");
    for (int i = 1; i <= days; i++) {
        state = ((float)rand() / RAND_MAX < t[state][0]) ? 0 : 1;
        printf("Day %d: %s\n", i, state ? "Rainy" : "Sunny");
    }
    return 0;
}
