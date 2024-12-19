// Write a program in C / C++ that accepts your alphabet symbols and a string from that 
// alphabet as input and verify whether the string is from the input alphabet or not. Also 
// print all the suffixes and prefixes of the input string


#include <iostream>
#include <string>
#include <set>
using namespace std;

bool isFromAlphabet(const string& str, const string& alphabet) {
    set<char> alphabetSet(alphabet.begin(), alphabet.end());
    for (char c : str) {
        if (alphabetSet.find(c) == alphabetSet.end()) {
            return false;
        }
    }
    return true;
}

void printSuffixesAndPrefixes(const string& str) {
    cout << "Suffixes:" << endl;
    for (int i = 0; i < str.length(); i++) {
        cout << str.substr(i) << endl;
    }
    
    cout << "Prefixes:" << endl;
    for (int i = 1; i <= str.length(); i++) {
        cout << str.substr(0, i) << endl;
    }
}

int main() {
    string alphabet, input;
    
    cout << "Enter alphabet symbols (no spaces): ";
    cin >> alphabet;
    
    cout << "Enter a string: ";
    cin >> input;
    
    if (isFromAlphabet(input, alphabet)) {
        cout << "The string is from the input alphabet." << endl;
        printSuffixesAndPrefixes(input);
    } else {
        cout << "The string is not from the input alphabet." << endl;
    }
    
    return 0;
}