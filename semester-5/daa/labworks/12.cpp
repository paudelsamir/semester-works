#include <iostream>
using namespace std;

int extendedGCD(int a, int b, int &x, int &y) {
    if (b == 0) {
        x = 1; y = 0;
        return a;
    }
    int x1, y1;
    int gcd = extendedGCD(b, a % b, x1, y1);
    x = y1;
    y = x1 - (a / b) * y1;
    return gcd;
}

int mod(int a, int m) {
    int res = a % m;
    return (res >= 0) ? res : res + m;
}

int main() {
    int a, b, m;
    cout << "Enter a, b, m for equation ax ≡ b (mod m): ";
    cin >> a >> b >> m;

    int x, y;
    int gcd = extendedGCD(a, m, x, y);

    if (b % gcd != 0) {
        cout << "No solution exists." << endl;
    } else {
        int x0 = mod(x * (b / gcd), m);
        cout << "One solution is x = " << x0 << endl;
        cout << "All solutions are of the form x = " << x0 << " + k*" << (m / gcd) << " for any integer k." << endl;
    }

    cout << "\nLab No.: 12" << endl;
    cout << "Name: Samir Paudel" << endl;
    cout << "Roll No./Section: 114-079/D" << endl;

    return 0;
}