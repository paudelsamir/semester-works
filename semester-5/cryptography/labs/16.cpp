#include <iostream>
#include <cmath>
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

int main() {
    int p, g, a, b;
    cout << "Enter prime modulus (p) and primitive root (g): ";
    cin >> p >> g;

    cout << "Enter private key of user A: ";
    cin >> a;
    cout << "Enter private key of user B: ";
    cin >> b;

    int A = modExp(g, a, p);
    int B = modExp(g, b, p);

    int keyA = modExp(B, a, p);
    int keyB = modExp(A, b, p);

    cout << "Shared secret key computed by A: " << keyA << endl;
    cout << "Shared secret key computed by B: " << keyB << endl;

    cout << "\nLab no: 16";
    cout << "\nName: Samir Paudel";
    cout << "\nRoll No. / Section: 114-079/D\n";

    return 0;
}

