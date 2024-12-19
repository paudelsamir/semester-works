#include <iostream>
#include <string>
using namespace std;

bool acceptDFA(const string& str) {
    int state = 0;
    for (char c : str) {
        switch (state) {
            case 0:
                state = (c == '0') ? 1 : 0;
                break;
            case 1:
                state = (c == '1') ? 2 : 1;
                break;
            case 2:
                state = (c == '0') ? 3 : 0;
                break;
            case 3:
                break;
        }
        if (state == 3) return true;
    }
    return false;
}

int main() {
    string input;
    
    cout << "Enter a string (only '0' and '1' allowed): ";
    cin >> input;
    
    if (acceptDFA(input)) {
        cout << "Accepted: The string contains '010'." << endl;
    } else {
        cout << "Rejected: The string does not contain '010'." << endl;
    }
    
    return 0;
}