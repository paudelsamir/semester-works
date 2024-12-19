// 2. Write a program in C or C++ that accepts a string and print the substrings as below. 
// Construct function for each of these task below in your program. 
// a. The leftmost substring of length n, where n is your input. 
// b. The rightmost substring of length n, where n is your input. 
// c. The substring from position n to m symbols where m and n are input 

#include <iostream>
#include <string>
using namespace std;

string leftmostSubstring(const string& str, int n) {
    return str.substr(0, n);
}

string rightmostSubstring(const string& str, int n) {
    return str.substr(str.length() - n);
}

string substringFromNtoM(const string& str, int n, int m) {
    return str.substr(n, m - n + 1);
}

int main() {
    string input;
    int n, m;
    
    cout << "Enter a string: ";
    cin >> input;
    
    cout << "Enter n for leftmost and rightmost substrings: ";
    cin >> n;
    cout << "Leftmost substring of length " << n << ": " << leftmostSubstring(input, n) << endl;
    cout << "Rightmost substring of length " << n << ": " << rightmostSubstring(input, n) << endl;
    
    cout << "Enter n and m for substring from n to m: ";
    cin >> n >> m;
    cout << "Substring from position " << n << " to " << m << ": " << substringFromNtoM(input, n, m) << endl;
    
    return 0;
}