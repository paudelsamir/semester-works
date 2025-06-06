#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void trim(vector<double> &list, double delta) {
    vector<double> trimmed;
    trimmed.push_back(list[0]);
    for (int i = 1; i < (int)list.size(); i++) {
        if (list[i] > trimmed.back() * (1 + delta)) {
            trimmed.push_back(list[i]);
        }
    }
    list = trimmed;
}

int main() {
    int n;
    double target, delta;
    cout << "Enter number of elements: ";
    cin >> n;
    vector<double> numbers(n);
    cout << "Enter elements: ";
    for (int i = 0; i < n; i++) cin >> numbers[i];
    cout << "Enter target sum: ";
    cin >> target;
    cout << "Enter delta (approximation factor, e.g., 0.1): ";
    cin >> delta;

    vector<double> sums = {0};

    for (double num : numbers) {
        vector<double> newSums;
        for (double s : sums) {
            newSums.push_back(s + num);
        }
        vector<double> merged;
        merge(sums.begin(), sums.end(), newSums.begin(), newSums.end(), back_inserter(merged));
        sort(merged.begin(), merged.end());
        trim(merged, delta);

        // Remove sums greater than target
        vector<double> filtered;
        for (double val : merged) {
            if (val <= target) filtered.push_back(val);
        }
        sums = filtered;
    }

    double result = *max_element(sums.begin(), sums.end());
    cout << "Approximate subset sum closest to target: " << result << endl;

    cout << "\nLab No.: 14(b)" << endl;
    cout << "Name: Samir Paudel" << endl;
    cout << "Roll No./Section: 114-079/D" << endl;

    return 0;
}
