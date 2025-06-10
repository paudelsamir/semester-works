#include <iostream>
using namespace std;

int gcd(int a, int b) {
    while (b != 0) {
        int r = a % b;
        a = b;
        b = r;
    }
    return a;
}

int totient(int n) {
    int count = 0;
    for (int i = 1; i <= n; i++)
        if (gcd(i, n) == 1) count++;
    return count;
}

int main() {
    int n;
    cout << "Enter positive number: ";
    cin >> n;

    cout << "Totient: " << totient(n) << endl;

    cout << "\nLab no: 13";
    cout << "\nName: Samir Paudel";
    cout << "\nRoll No. / Section: 114-079/D\n";

    return 0;
}

