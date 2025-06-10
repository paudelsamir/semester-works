#include<iostream>
using namespace std;

int modInverse(int a, int n) {
    int r0 = a, r1 = n;
    int s0 = 1, s1 = 0;

    while (r1 != 0) {
        int q = r0 / r1;
        int r = r0 % r1;
        int s = s0 - q * s1;
        r0 = r1; r1 = r;
        s0 = s1; s1 = s;
    }
    if (r0 != 1) return -1; // inverse doesn't exist
    return (s0 + n) % n;
}

int main() {
    int a, n;
    cout << "Enter number and modulo: ";
    cin >> a >> n;

    int inv = modInverse(a, n);
    if (inv == -1)
        cout << "Multiplicative inverse does not exist\n";
    else
        cout << "Multiplicative inverse: " << inv << endl;

    cout << "\nLab no: 9";
    cout << "\nName: Samir Paudel";
    cout << "\nRoll No. / Section: 114-079/D\n";

    return 0;
}

