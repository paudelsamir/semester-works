#include<iostream>
using namespace std;

string encrypt(string text, int key) {
    for (char &c : text)
        if (isalpha(c))
            c = isupper(c) ? (c - 'A' + key) % 26 + 'A' : (c - 'a' + key) % 26 + 'a';
    return text;
}

string decrypt(string text, int key) {
    return encrypt(text, 26 - key); // reverse shift
}

int main() {
    int choice, key;
    string text;
    cout << "1. Encrypt\n2. Decrypt\nChoice: ";
    cin >> choice;
    cout << "Enter text: ";
    cin >> text;
    cout << "Enter key: ";
    cin >> key;

    string result = (choice == 1) ? encrypt(text, key) : decrypt(text, key);
    cout << "Result: " << result << endl;

    cout << "\nLab no: 1";
    cout << "\nName: Samir Paudel";
    cout << "\nRoll No. / Section: 114-079/D\n";

    return 0;
}

