#include<iostream>
#include<vector>
#include<map>
#include<string>
using namespace std;

string prepare(string s) {
    string r = "";
    map<char, bool> m;
    for (char c : s) {
        if (c == 'j') c = 'i';
        if (!m[c] && isalpha(c)) {
            r += c;
            m[c] = true;
        }
    }
    return r;
}

void generateMatrix(string key, char m[5][5], map<char, pair<int,int>> &pos) {
    key = prepare(key);
    for (char c = 'a'; c <= 'z'; ++c)
        if (c != 'j') key += c;

    string used = "";
    int idx = 0;
    for (char c : key)
        if (used.find(c) == string::npos) used += c;

    for (int i = 0; i < 25; ++i) {
        m[i/5][i%5] = used[i];
        pos[used[i]] = {i/5, i%5};
    }
}

string formatText(string s) {
    string r = "";
    for (char c : s) if (isalpha(c)) r += (c == 'j') ? 'i' : c;
    for (size_t i = 0; i < r.size(); i += 2) {
        if (i+1 == r.size() || r[i] == r[i+1]) {
            r.insert(i+1, 1, 'x');
        }
    }
    if (r.size() % 2) r += 'x';
    return r;
}

string process(string txt, char m[5][5], map<char, pair<int,int>> &pos, bool encrypt) {
    txt = formatText(txt);
    string res = "";
    for (int i = 0; i < txt.size(); i += 2) {
        auto [r1, c1] = pos[txt[i]];
        auto [r2, c2] = pos[txt[i+1]];
        if (r1 == r2) {
            res += m[r1][(c1 + (encrypt ? 1 : 4)) % 5];
            res += m[r2][(c2 + (encrypt ? 1 : 4)) % 5];
        } else if (c1 == c2) {
            res += m[(r1 + (encrypt ? 1 : 4)) % 5][c1];
            res += m[(r2 + (encrypt ? 1 : 4)) % 5][c2];
        } else {
            res += m[r1][c2];
            res += m[r2][c1];
        }
    }
    return res;
}

int main() {
    string key, txt;
    char m[5][5];
    map<char, pair<int,int>> pos;
    int ch;

    cout << "Enter key: ";
    cin >> key;
    generateMatrix(key, m, pos);

    cout << "Key Matrix:\n";
    for (int i = 0; i < 5; ++i) {
        for (int j = 0; j < 5; ++j) cout << m[i][j] << ' ';
        cout << endl;
    }

    cout << "1. Encrypt\n2. Decrypt\nChoice: ";
    cin >> ch;
    cout << "Enter text: ";
    cin.ignore();
    getline(cin, txt);
    // Convert to lowercase for consistency
    for (char &c : txt) c = tolower(c);

    string result = process(txt, m, pos, ch == 1);
    cout << "Result: " << result << endl;

    cout << "\nLab no: 2";
    cout << "\nName: Samir Paudel";
    cout << "\nRoll No. / Section: 114-079/D\n";

    return 0;
}

