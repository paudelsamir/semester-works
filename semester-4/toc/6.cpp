#include <iostream>
#include <string>
#include <set>
#include <cctype>
using namespace std;

set<string> keywords = {"int", "float", "char", "double", "if", "else", "while", "for", "return"};

bool isValidIdentifier(const string& str) {
    if (str.empty() || isdigit(str[0])) return false;
    for (char c : str) {
        if (!isalnum(c) && c != '_') return false;
    }
    return true;
}

int main() {
    string input;
    
    cout << "Enter a string to validate: ";
    cin >> input;
    
    if (keywords.find(input) != keywords.end()) {
        cout << "'" << input << "' is a C keyword." << endl;
    } else if (isValidIdentifier(input)) {
        cout << "'" << input << "' is a valid C identifier." << endl;
    } else {
        cout << "'" << input << "' is neither a valid C identifier nor a keyword." << endl;
    }
    
    return 0;
}