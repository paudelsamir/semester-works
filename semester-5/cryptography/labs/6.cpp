#include<iostream>
using namespace std;

int additiveInverse(int a, int n) {
    return (n - (a % n)) % n;
}

int main() {
    int a, n;
    cout << "Enter number and modulo n: ";
    cin >> a >> n;

    cout << "Additive Inverse: " << additiveInverse(a, n) << endl;

    cout << "\nLab no: 6";
    cout << "\nName: Samir Paudel";
    cout << "\nRoll No. / Section: 114-079/D\n";

    return 0;
}

