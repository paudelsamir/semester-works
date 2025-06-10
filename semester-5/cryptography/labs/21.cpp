#include <iostream>
#include <iomanip>
#include <openssl/md5.h>
using namespace std;

int main() {
    string input;
    cout << "Enter string to hash: ";
    getline(cin, input);

    unsigned char digest[MD5_DIGEST_LENGTH];
    MD5((unsigned char*)input.c_str(), input.length(), digest);

    cout << "MD5 hash: ";
    for (int i = 0; i < MD5_DIGEST_LENGTH; i++)
        cout << hex << setw(2) << setfill('0') << (int)digest[i];
    cout << endl;

    cout << "\nLab no: 21";
    cout << "\nName: Samir Paudel";
    cout << "\nRoll No. / Section: 114-079/D\n";

    return 0;
}

