#include <iostream>
#include <string>
#include <stack>
using namespace std;

bool acceptPDA(const string& str) {
    stack<char> pda;
    for (char c : str) {
        if (c == '0') {
            pda.push('0');
        } else if (c == '1') {
            if (pda.empty() || pda.top() == '1') {
                pda.push('1');
            } else {
                pda.pop();
            }
        }
    }
    return pda.empty();
}

int main() {
    string input;
    
    cout << "Enter a string (only '0' and '1' allowed): ";
    cin >> input;
    
    if (acceptPDA(input)) {
        cout << "Accepted: The string has an equal number of 0s and 1s." << endl;
    } else {
        cout << "Rejected: The string does not have an equal number of 0s and 1s." << endl;
    }
    
    return 0;
}