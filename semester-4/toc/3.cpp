#include <iostream>
#include <string>
using namespace std;

void printAllPrefixes(const string& str) {
    cout << "All Prefixes:" << endl;
    for (int i = 1; i <= str.length(); i++) {
        cout << str.substr(0, i) << endl;
    }
}

int main() {
    string input;
    
    cout << "Enter a string: ";
    cin >> input;
    
    printAllPrefixes(input);
    
    return 0;
}
