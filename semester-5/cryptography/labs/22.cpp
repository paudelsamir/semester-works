#include <iostream>
#include <iomanip>
#include <openssl/sha.h>
using namespace std;

int main() {
    string input;
    cout << "Enter string to hash: ";
    getline(cin, input);

    unsigned char digest[SHA_DIGEST_LENGTH];
    SHA1((unsigned char*)input.c_str(), input.length(), digest);

    cout << "SHA-1 hash: ";
    for (int i = 0; i < SHA_DIGEST_LENGTH; i++)
        cout << hex << setw(2) << setfill('0') << (int)digest[i];
    cout << endl;

    cout << "\nLab no: 22";
    cout << "\nName: Samir Paudel";
    cout << "\nRoll No. / Section: 114-079/D\n";

    return 0;
}

