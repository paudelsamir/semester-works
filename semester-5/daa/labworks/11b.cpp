#include <iostream>
#include <vector>
using namespace std;

int maxVal = 0;

void knapsackBacktrack(vector<int> &weights, vector<int> &values, int n, int capacity, int index, int currentWeight, int currentValue) {
    if (currentWeight > capacity) return; // prune path exceeding capacity

    if (index == n) {
        if (currentValue > maxVal)
            maxVal = currentValue;
        return;
    }

    // Include current item
    knapsackBacktrack(weights, values, n, capacity, index + 1, currentWeight + weights[index], currentValue + values[index]);

    // Exclude current item
    knapsackBacktrack(weights, values, n, capacity, index + 1, currentWeight, currentValue);
}

int main() {
    int n, capacity;
    cout << "Enter number of items: ";
    cin >> n;
    vector<int> weights(n), values(n);
    cout << "Enter weights of items: ";
    for (int i = 0; i < n; i++) cin >> weights[i];
    cout << "Enter values of items: ";
    for (int i = 0; i < n; i++) cin >> values[i];
    cout << "Enter capacity of knapsack: ";
    cin >> capacity;

    knapsackBacktrack(weights, values, n, capacity, 0, 0, 0);

    cout << "Maximum value possible: " << maxVal << endl;

    cout << "\nLab No.: 11(b)" << endl;
    cout << "Name: Samir Paudel" << endl;
    cout << "Roll No./Section: 114-079/D" << endl;

    return 0;
}
