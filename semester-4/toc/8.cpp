#include <iostream>
#include <string>
using namespace std;

bool acceptNFA(const string& str) {
    if (str.length() < 2) return false;
    return (str[0] == '0' && str[1] == '1');
}

int main() {
    string input;
    
    cout << "Enter a string (only '0' and '1' allowed): ";
    cin >> input;
    
    if (acceptNFA(input)) {
        cout << "Accepted: The string starts with '01'." << endl;
    } else {
        cout << "Rejected: The string does not start with '01'." << endl;
    }
    
    return 0;
}