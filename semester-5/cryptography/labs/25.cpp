#include <iostream>
#include <string>
using namespace std;

int main() {
    string username, password;
    string storedUser = "user1";
    string storedPass = "pass123";

    cout << "Enter username: ";
    cin >> username;
    cout << "Enter password: ";
    cin >> password;

    if (username == storedUser && password == storedPass) {
        cout << "Login successful\n";
    } else {
        cout << "Invalid credentials\n";
    }

    cout << "\nLab no: 25";
    cout << "\nName: Samir Paudel";
    cout << "\nRoll No. / Section: 114-079/D\n";

    return 0;
}