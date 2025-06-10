#include <stdio.h>
#include <string.h>

int main() {
    int n;
    printf("Lab 4B: Poker Test\n"); // Added lab number at the top
    printf("Enter number of random numbers (e.g., 5): ");
    scanf("%d", &n);

    char nums[n][10];
    printf("Enter %d random numbers (e.g., 0.12345):\n", n);
    for (int i = 0; i < n; i++) {
        scanf("%s", nums[i]);
    }

    int all_diff = 0, one_pair = 0, two_pair = 0, three_kind = 0;

    for (int i = 0; i < n; i++) {
        int freq[10] = {0};
        for (int j = 2; j < 7; j++) { // after decimal
            freq[nums[i][j] - '0']++;
        }

        int pairs = 0, threes = 0;
        int unique_digits = 0;

        for (int j = 0; j < 10; j++) {
            if (freq[j] == 2) pairs++;
            if (freq[j] == 3) threes++;
            if (freq[j] == 1) unique_digits++;
        }

        if (unique_digits == 5)
            all_diff++;
        else if (pairs == 1 && threes == 0)
            one_pair++;
        else if (pairs == 2)
            two_pair++;
        else if (threes == 1)
            three_kind++;
    }

    printf("\nPoker Test Result:\n");
    printf("All digits different: %d\n", all_diff);
    printf("One Pair: %d\n", one_pair);
    printf("Two Pair: %d\n", two_pair);
    printf("Three of a Kind: %d\n", three_kind);

    return 0;
}
