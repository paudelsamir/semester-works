#include <iostream>
#include <string>
using namespace std;

bool acceptDFA(const string& str) {
    bool state = false;  // false: not accepted, true: accepted
    for (char c : str) {
        if (c == 'a') state = false;
        else if (c == 'b') state = true;
        else return false;  // invalid input
    }
    return state;
}

int main() {
    string input;
    
    cout << "Enter a string (only 'a' and 'b' allowed): ";
    cin >> input;
    
    if (acceptDFA(input)) {
        cout << "Accepted: The string ends with 'b'." << endl;
    } else {
        cout << "Rejected: The string does not end with 'b' or contains invalid characters." << endl;
    }
    
    return 0;
}
