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
                state = (c == '0') ? 1 : 2;
                break;
            case 2:
                state = (c == '0') ? 1 : 0;
                break;
        }
    }
    return state == 2;
}

int main() {
    string input;
    
    cout << "Enter a string (only '0' and '1' allowed): ";
    cin >> input;
    
    if (acceptDFA(input)) {
        cout << "Accepted: The string ends with '01'." << endl;
    } else {
        cout << "Rejected: The string does not end with '01'." << endl;
    }
    
    return 0;
}