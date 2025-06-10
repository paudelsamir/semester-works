#include<iostream>
using namespace std;

void extendedGCD(int a, int b) {
    int r0 = a, r1 = b;
    int s0 = 1, s1 = 0;
    int t0 = 0, t1 = 1;

    cout << "q\tr\ts\tt\n";
    while (r1 != 0) {
        int q = r0 / r1;
        int r = r0 % r1;
        int s = s0 - q * s1;
        int t = t0 - q * t1;
        cout << q << '\t' << r << '\t' << s << '\t' << t << '\n';
        r0 = r1; r1 = r;
        s0 = s1; s1 = s;
        t0 = t1; t1 = t;
    }
    cout << "gcd: " << r0 << ", x: " << s0 << ", y: " << t0 << endl;
}

int main() {
    int a, b;
    cout << "Enter two numbers: ";
    cin >> a >> b;

    extendedGCD(a, b);

    cout << "\nLab no: 8";
    cout << "\nName: Samir Paudel";
    cout << "\nRoll No. / Section: 114-079/D\n";

    return 0;
}

