#include<iostream>
#include<vector>
using namespace std;

string encrypt(string txt, int rails) {
    vector<string> fence(rails);
    int dir = 1, row = 0;

    for (char c : txt) {
        fence[row] += c;
        row += dir;
        if (row == 0 || row == rails - 1) dir *= -1;
    }

    string res;
    for (auto &r : fence) res += r;
    return res;
}

string decrypt(string txt, int rails) {
    vector<int> len(rails, 0), pos(rails, 0);
    int dir = 1, row = 0;

    for (int i = 0; i < txt.size(); ++i) {
        len[row]++;
        row += dir;
        if (row == 0 || row == rails - 1) dir *= -1;
    }

    vector<string> fence(rails);
    int idx = 0;
    for (int i = 0; i < rails; ++i)
        fence[i] = txt.substr(idx, len[i]), idx += len[i];

    string res;
    dir = 1, row = 0;
    for (int i = 0; i < txt.size(); ++i) {
        res += fence[row][pos[row]++];
        row += dir;
        if (row == 0 || row == rails - 1) dir *= -1;
    }

    return res;
}

int main() {
    int choice, rails;
    string text;
    cout << "1. Encrypt\n2. Decrypt\nChoice: ";
    cin >> choice;
    cout << "Enter text: ";
    cin >> text;
    cout << "Enter number of rails: ";
    cin >> rails;

    string result = (choice == 1) ? encrypt(text, rails) : decrypt(text, rails);
    cout << "Result: " << result << endl;

    cout << "\nLab no: 3";
    cout << "\nName: Samir Paudel";
    cout << "\nRoll No. / Section: 114-079/D\n";

    return 0;
}

