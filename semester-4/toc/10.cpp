#include <iostream>
#include <stack>
#include <string>

using namespace std;

bool isValid(string input) {
    stack<char> s;

    for (char ch : input) {
        if (ch == '0') {
            s.push('0'); 
        } else if (ch == '1') {
            if (s.empty()) return false; 
            s.pop();  
        }
    }

    return s.empty(); 
}

int main() {
    string inputs[] = {"0011", "01", "000111", "10", "1100"};

    for (string input : inputs) {
        if (isValid(input)) {
            cout << "Input: " << input << " is Accepted" << endl;
        } else {
            cout << "Input: " << input << " is Rejected" << endl;
        }
    }

    return 0;
}
