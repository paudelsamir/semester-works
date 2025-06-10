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

bool isPrimitiveRoot(int g, int n) {
    int phi = n - 1;
    for (int i = 1; i < phi; i++) {
        if ((int)pow(g, i) % n == 1) return false;
    }
    return true;
}

int main() {
    int n;
    cout << "Enter prime number: ";
    cin >> n;

    cout << "Primitive roots modulo " << n << " are:\n";
    for (int g = 2; g < n; g++) {
        bool flag = true;
        for (int i = 1; i < n - 1; i++) {
            if ((int)pow(g, i) % n == 1) {
                flag = false;
                break;
            }
        }
        if (flag) cout << g << " ";
    }
    cout << endl;

    cout << "\nLab no: 14";
    cout << "\nName: Samir Paudel";
    cout << "\nRoll No. / Section: 114-079/D\n";

    return 0;
}

