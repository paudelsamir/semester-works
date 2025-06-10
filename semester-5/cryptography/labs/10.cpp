#include<iostream>
using namespace std;

int mod26(int x) {
    x %= 26;
    return (x < 0) ? x + 26 : x;
}

int modInverse(int a, int m) {
    a %= m;
    for (int x = 1; x < m; x++)
        if ((a * x) % m == 1)
            return x;
    return -1;
}

void getMatrixInverse(int key[2][2], int inv[2][2]) {
    int det = mod26(key[0][0]*key[1][1] - key[0][1]*key[1][0]);
    int detInv = modInverse(det, 26);
    inv[0][0] = mod26(detInv * key[1][1]);
    inv[0][1] = mod26(-detInv * key[0][1]);
    inv[1][0] = mod26(-detInv * key[1][0]);
    inv[1][1] = mod26(detInv * key[0][0]);
}

void encrypt(int key[2][2], string &text) {
    for (int i = 0; i < text.size(); i += 2) {
        int x = (text[i] - 'A');
        int y = (i+1 < text.size()) ? (text[i+1] - 'A') : 'X' - 'A';
        text[i] = (key[0][0]*x + key[0][1]*y) % 26 + 'A';
        if(i+1 < text.size())
            text[i+1] = (key[1][0]*x + key[1][1]*y) % 26 + 'A';
    }
}

void decrypt(int inv[2][2], string &text) {
    for (int i = 0; i < text.size(); i += 2) {
        int x = (text[i] - 'A');
        int y = (i+1 < text.size()) ? (text[i+1] - 'A') : 'X' - 'A';
        text[i] = (inv[0][0]*x + inv[0][1]*y) % 26 + 'A';
        if(i+1 < text.size())
            text[i+1] = (inv[1][0]*x + inv[1][1]*y) % 26 + 'A';
    }
}

int main() {
    int key[2][2], inv[2][2];
    string text;
    int choice;

    cout << "Enter 4 letters key (A-Z): ";
    for (int i = 0; i < 2; i++)
        for(int j = 0; j < 2; j++) {
            char c; cin >> c;
            key[i][j] = c - 'A';
        }

    getMatrixInverse(key, inv);

    cout << "1. Encrypt\n2. Decrypt\nChoice: ";
    cin >> choice;

    cout << "Enter text (A-Z, even length): ";
    cin >> text;
    if(text.size() % 2 != 0) text += 'X';

    if(choice == 1) encrypt(key, text);
    else decrypt(inv, text);

    cout << "Result: " << text << endl;

    cout << "\nLab no: 10";
    cout << "\nName: Samir Paudel";
    cout << "\nRoll No. / Section: 114-079/D\n";

    return 0;
}

