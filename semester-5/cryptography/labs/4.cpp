#include<iostream>
using namespace std;

string formatKey(string text, string key) {
    int x = text.size();
    for (int i = key.size(); i < x; i++) key += key[i % key.size()];
    return key;
}

string encrypt(string text, string key) {
    string cipher = "";
    for (int i = 0; i < text.size(); i++)
        cipher += (char)(((text[i] - 'A') + (key[i] - 'A')) % 26 + 'A');
    return cipher;
}

string decrypt(string cipher, string key) {
    string text = "";
    for (int i = 0; i < cipher.size(); i++)
        text += (char)(((cipher[i] - key[i] + 26) % 26) + 'A');
    return text;
}

int main() {
    int choice;
    string text, key;
    cout << "1. Encrypt\n2. Decrypt\nChoice: ";
    cin >> choice;
    cout << "Enter text (CAPITAL ONLY): ";
    cin >> text;
    cout << "Enter key (CAPITAL ONLY): ";
    cin >> key;

    key = formatKey(text, key);
    string result = (choice == 1) ? encrypt(text, key) : decrypt(text, key);
    cout << "Result: " << result << endl;

    cout << "\nLab no: 4";
    cout << "\nName: Samir Paudel";
    cout << "\nRoll No. / Section: 114-079/D\n";

    return 0;
}

