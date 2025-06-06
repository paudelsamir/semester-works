#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

const int INSERT_COST = 1;
const int DELETE_COST = 1;
const int SUBSTITUTE_COST = 2;

void printOperations(string str1, string str2, int **dp, int m, int n) {
    cout << "\nSequence of operations:\n";
    while (m > 0 && n > 0) {
        if (str1[m - 1] == str2[n - 1]) {
            m--; n--;
        }
        else if (dp[m][n] == dp[m - 1][n - 1] + SUBSTITUTE_COST) {
            cout << "Substitute '" << str1[m - 1] << "' with '" << str2[n - 1] << "'\n";
            m--; n--;
        }
        else if (dp[m][n] == dp[m - 1][n] + DELETE_COST) {
            cout << "Delete '" << str1[m - 1] << "'\n";
            m--;
        }
        else {
            cout << "Insert '" << str2[n - 1] << "'\n";
            n--;
        }
    }

    while (m > 0) {
        cout << "Delete '" << str1[m - 1] << "'\n";
        m--;
    }
    while (n > 0) {
        cout << "Insert '" << str2[n - 1] << "'\n";
        n--;
    }
}

int main() {
    string str1, str2;
    cout << "Enter first string: ";
    cin >> str1;
    cout << "Enter second string: ";
    cin >> str2;

    int m = str1.length();
    int n = str2.length();

    // Dynamically allocate dp array of size (m+1) x (n+1)
    int **dp = new int*[m+1];
    for (int i = 0; i <= m; i++)
        dp[i] = new int[n+1];

    // Initialize base cases
    for (int i = 0; i <= m; i++)
        dp[i][0] = i * DELETE_COST;
    for (int j = 0; j <= n; j++)
        dp[0][j] = j * INSERT_COST;

    // Fill DP table
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (str1[i - 1] == str2[j - 1])
                dp[i][j] = dp[i - 1][j - 1];
            else {
                int del = dp[i - 1][j] + DELETE_COST;
                int ins = dp[i][j - 1] + INSERT_COST;
                int sub = dp[i - 1][j - 1] + SUBSTITUTE_COST;
                dp[i][j] = min(del, min(ins, sub));
            }
        }
    }

    cout << "\nMinimum Edit Distance: " << dp[m][n] << endl;
    printOperations(str1, str2, dp, m, n);

    // Free dynamically allocated memory
    for (int i = 0; i <= m; i++)
        delete[] dp[i];
    delete[] dp;

    cout << "\nLab No.: 9(c)" << endl;
    cout << "Name: Samir Paudel" << endl;
    cout << "Roll No./Section: 114-079/D" << endl;

    return 0;
}
