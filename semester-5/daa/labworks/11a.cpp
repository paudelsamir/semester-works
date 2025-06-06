#include <iostream>
#include <vector>
using namespace std;

bool subsetSumBacktrack(vector<int> &arr, int n, int sum, int currentSum, int index) {
    if (currentSum == sum) return true;
    if (index == n || currentSum > sum) return false;

    // Include current element
    if (subsetSumBacktrack(arr, n, sum, currentSum + arr[index], index + 1)) return true;

    // Exclude current element
    return subsetSumBacktrack(arr, n, sum, currentSum, index + 1);
}

int main() {
    int n, sum;
    cout << "Enter number of elements: ";
    cin >> n;
    vector<int> arr(n);
    cout << "Enter elements: ";
    for (int i = 0; i < n; i++) cin >> arr[i];
    cout << "Enter target sum: ";
    cin >> sum;

    bool found = subsetSumBacktrack(arr, n, sum, 0, 0);

    if (found)
        cout << "Subset with sum " << sum << " exists." << endl;
    else
        cout << "No subset with sum " << sum << " exists." << endl;

    cout << "\nLab No.: 11(a)" << endl;
    cout << "Name: Samir Paudel" << endl;
    cout << "Roll No./Section: 114-079/D" << endl;

    return 0;
}