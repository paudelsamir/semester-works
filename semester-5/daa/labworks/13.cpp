#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

long long modExp(long long base, long long exp, long long mod) {
    long long result = 1;
    base = base % mod;
    while (exp > 0) {
        if (exp & 1) result = (result * base) % mod;
        base = (base * base) % mod;
        exp >>= 1;
    }
    return result;
}

bool millerTest(long long d, long long n) {
    long long a = 2 + rand() % (n - 4);
    long long x = modExp(a, d, n);
    if (x == 1 || x == n - 1) return true;

    while (d != n - 1) {
        x = (x * x) % n;
        d *= 2;

        if (x == 1) return false;
        if (x == n - 1) return true;
    }
    return false;
}

bool isPrime(long long n, int k) {
    if (n <= 1 || n == 4) return false;
    if (n <= 3) return true;

    long long d = n - 1;
    while (d % 2 == 0) d /= 2;

    for (int i = 0; i < k; i++) {
        if (!millerTest(d, n)) return false;
    }
    return true;
}

int main() {
    srand(time(0));
    long long n;
    int k;
    cout << "Enter number to test: ";
    cin >> n;
    cout << "Enter number of iterations: ";
    cin >> k;

    if (isPrime(n, k))
        cout << n << " is probably prime." << endl;
    else
        cout << n << " is composite." << endl;

    cout << "\nLab No.: 13" << endl;
    cout << "Name: Samir Paudel" << endl;
    cout << "Roll No./Section: 114-079/D" << endl;

    return 0;
}

