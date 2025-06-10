#include <iostream>
#include <string>
#include <cstdlib>
#include <ctime>
using namespace std;

string generateToken() {
    string token = "";
    for (int i = 0; i < 16; i++) {
        char c = 'A' + rand() % 26;
        token += c;
    }
    return token;
}

int main() {
    srand(time(0));
    string username, password;
    string storedToken = "";

    cout << "Login\nUsername: ";
    cin >> username;
    cout << "Password: ";
    cin >> password;

    if (username == "user" && password == "pass") {
        storedToken = generateToken();
        cout << "Login successful\nYour token: " << storedToken << endl;
    } else {
        cout << "Invalid credentials\n";
        return 0;
    }

    string inputToken;
    cout << "Enter token for authentication: ";
    cin >> inputToken;

    if (inputToken == storedToken)
        cout << "Token valid. Access granted\n";
    else
        cout << "Invalid token. Access denied\n";

    cout << "\nLab no: 24";
    cout << "\nName: Samir Paudel";
    cout << "\nRoll No. / Section: 114-079/D\n";

    return 0;
}

