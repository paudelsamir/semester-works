#include <iostream>
using namespace std;

int modExp(int base, int exp, int mod) {
    int result = 1;
    base %= mod;
    while (exp > 0) {
        if (exp & 1) result = (result * base) % mod;
        base = (base * base) % mod;
        exp >>= 1;
    }
    return result;
}

int discreteLog(int g, int h, int n) {
    for (int x = 0; x < n; x++)
        if (modExp(g, x, n) == h)
            return x;
    return -1;
}

int main() {
    int g, h, n;
    cout << "Enter primitive root (g), number (h), and modulo (n): ";
    cin >> g >> h >> n;

    int res = discreteLog(g, h, n);
    if (res == -1) cout << "No discrete log found\n";
    else cout << "Discrete log is: " << res << endl;

    cout << "\nLab no: 15";
    cout << "\nName: Samir Paudel";
    cout << "\nRoll No. / Section: 114-079/D\n";

    return 0;
}

