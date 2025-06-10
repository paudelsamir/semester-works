#include <iostream>
#include <cmath>
using namespace std;

int gcd(int a, int b) {
    while (b != 0) {
        int r = a % b;
        a = b;
        b = r;
    }
    return a;
}

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
    int p, q, n, totient, e, d = 0;
    cout << "Enter prime p and q: ";
    cin >> p >> q;
    n = p * q;
    totient = (p - 1) * (q - 1);

    for (e = 2; e < totient; e++) {
        if (gcd(e, totient) == 1) break;
    }

    for (int k = 1; k < 10000; k++) {
        if ((1 + k * totient) % e == 0) {
            d = (1 + k * totient) / e;
            break;
        }
    }

    int msg;
    cout << "Enter message to encrypt (int): ";
    cin >> msg;

    int cipher = modExp(msg, e, n);
    int plain = modExp(cipher, d, n);

    cout << "Encrypted: " << cipher << endl;
    cout << "Decrypted: " << plain << endl;

    cout << "\nLab no: 17";
    cout << "\nName: Samir Paudel";
    cout << "\nRoll No. / Section: 114-079/D\n";

    return 0;
}

