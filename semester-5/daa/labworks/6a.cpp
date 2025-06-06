#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Item {
    int weight, value;
    double ratio;
};

bool compare(Item a, Item b) {
    return a.ratio > b.ratio;
}

double fractionalKnapsack(int W, vector<Item> items) {
    for (auto &item : items)
        item.ratio = (double)item.value / item.weight;

    sort(items.begin(), items.end(), compare);

    double totalValue = 0.0;
    for (auto item : items) {
        if (W == 0)
            break;
        if (item.weight <= W) {
            totalValue += item.value;
            W -= item.weight;
        } else {
            totalValue += item.ratio * W;
            W = 0;
        }
    }
    return totalValue;
}

int main() {
    int n, W;
    cout << "Enter number of items: ";
    cin >> n;
    vector<Item> items(n);

    for (int i = 0; i < n; i++) {
        cout << "Enter value and weight of item " << i + 1 << ": ";
        cin >> items[i].value >> items[i].weight;
    }

    cout << "Enter knapsack capacity: ";
    cin >> W;

    double maxValue = fractionalKnapsack(W, items);
    cout << "Maximum value in knapsack = " << maxValue << endl;

    cout << "\nLab No.: 6(a)" << endl;
    cout << "Name: Samir Paudel" << endl;
    cout << "Roll No./Section: 114-079/D" << endl;

    return 0;
}
