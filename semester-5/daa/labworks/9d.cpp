#include <iostream>
#include <vector>
#include <climits>
using namespace std;

int tsp(int mask, int pos, int n, vector<vector<int>>& cost, vector<vector<int>>& dp) {
    if (mask == (1 << n) - 1) {
        return cost[pos][0]; // return to start city
    }
    if (dp[mask][pos] != -1) return dp[mask][pos];

    int ans = INT_MAX;
    for (int city = 0; city < n; city++) {
        if ((mask & (1 << city)) == 0) {
            int newAns = cost[pos][city] + tsp(mask | (1 << city), city, n, cost, dp);
            ans = min(ans, newAns);
        }
    }
    return dp[mask][pos] = ans;
}

int main() {
    int n;
    cout << "Enter number of cities: ";
    cin >> n;
    vector<vector<int>> cost(n, vector<int>(n));
    cout << "Enter cost matrix:\n";
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> cost[i][j];
        }
    }
    vector<vector<int>> dp(1 << n, vector<int>(n, -1));
    int result = tsp(1, 0, n, cost, dp);

    cout << "Minimum cost of travelling all cities: " << result << endl;

    cout << "\nLab No.: 9(d)" << endl;
    cout << "Name: Samir Paudel" << endl;
    cout << "Roll No./Section: 114-079/D" << endl;

    return 0;
}
