#include <iostream>
#include <climits>
using namespace std;

void printOptimalParenthesis(int i, int j, int s[10][10], char& name) {
    if (i == j) {
        cout << name++;
        return;
    }
    cout << "(";
    printOptimalParenthesis(i, s[i][j], s, name);
    printOptimalParenthesis(s[i][j] + 1, j, s, name);
    cout << ")";
}

int main() {
    int n;
    cout << "Enter number of matrices: ";
    cin >> n;
    int p[n + 1];

    cout << "Enter dimensions (p0 to p" << n << "): ";
    for (int i = 0; i <= n; i++) {
        cin >> p[i];
    }

    int m[10][10] = {0}, s[10][10];

    for (int L = 2; L <= n; L++) {
        for (int i = 1; i <= n - L + 1; i++) {
            int j = i + L - 1;
            m[i][j] = INT_MAX;
            for (int k = i; k < j; k++) {
                int q = m[i][k] + m[k + 1][j] + p[i - 1]*p[k]*p[j];
                if (q < m[i][j]) {
                    m[i][j] = q;
                    s[i][j] = k;
                }
            }
        }
    }

    cout << "Minimum number of multiplications is: " << m[1][n] << endl;

    cout << "Optimal parenthesization is: ";
    char name = 'A';
    printOptimalParenthesis(1, n, s, name);
    cout << endl;

    cout << "\nLab No.: 9(a)" << endl;
    cout << "Name: Samir Paudel" << endl;
    cout << "Roll No./Section: 114-079/D" << endl;

    return 0;
}

