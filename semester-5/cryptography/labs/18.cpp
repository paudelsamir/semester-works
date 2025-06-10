#include <iostream>
#include <cstdlib>
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
    int p, g, x, k, m;
    cout << "Enter prime p and generator g: ";
    cin >> p >> g;

    cout << "Enter private key x (less than p): ";
    cin >> x;

    int y = modExp(g, x, p);
    cout << "Public key y: " << y << endl;

    cout << "Enter message m (< p): ";
    cin >> m;

    cout << "Enter random ephemeral key k (< p): ";
    cin >> k;

    int c1 = modExp(g, k, p);
    int c2 = (m * modExp(y, k, p)) % p;

    cout << "Ciphertext: (" << c1 << ", " << c2 << ")\n";

    // decryption
    int s = modExp(c1, x, p);
    // multiplicative inverse of s mod p via Fermat's little theorem (p prime)
    int s_inv = modExp(s, p - 2, p);
    int decrypted = (c2 * s_inv) % p;

    cout << "Decrypted message: " << decrypted << endl;

    cout << "\nLab no: 18";
    cout << "\nName: Samir Paudel";
    cout << "\nRoll No. / Section: 114-079/D\n";

    return 0;
}

