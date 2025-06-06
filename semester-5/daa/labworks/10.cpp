#include <iostream>
#include <vector>
using namespace std;

int fibMemo(int n, vector<int> &memo) {
    if (n <= 1) return n;
    if (memo[n] != -1) return memo[n];
    memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
    return memo[n];
}

int main() {
    int n;
    cout << "Enter the term (n) to find in Fibonacci sequence: ";
    cin >> n;

    vector<int> memo(n + 1, -1);
    int result = fibMemo(n, memo);

    cout << "Fibonacci term at position " << n << " is: " << result << endl;

    cout << "\nLab No.: 10" << endl;
    cout << "Name: Samir Paudel" << endl;
    cout << "Roll No./Section: 114-079/D" << endl;

    return 0;
}