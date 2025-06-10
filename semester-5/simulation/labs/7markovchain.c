#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
    int days;
    int current_state; // 0: Sunny, 1: Rainy

    printf("Lab 7: Markov Chain Weather Simulation\n"); // Added lab number at the top

    printf("Enter number of days to simulate (e.g., 10): ");
    scanf("%d", &days);

    printf("Enter current weather (0 for Sunny, 1 for Rainy): ");
    scanf("%d", &current_state);

    // Transition probabilities matrix
    // Rows: current state, Columns: next state
    // Example: From Sunny to Sunny = 0.8, Sunny to Rainy = 0.2
    float transition[2][2] = {
        {0.8, 0.2},  // Sunny
        {0.4, 0.6}   // Rainy
    };

    srand(time(NULL));

    printf("\nDay 0: %s\n", current_state == 0 ? "Sunny" : "Rainy");

    for (int i = 1; i <= days; i++) {
        float r = (float)rand() / RAND_MAX; // random between 0 and 1
        if (r < transition[current_state][0])
            current_state = 0;
        else
            current_state = 1;

        printf("Day %d: %s\n", i, current_state == 0 ? "Sunny" : "Rainy");
    }

    return 0;
}
