#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

int generateOTP() {
    return 100000 + rand() % 900000; // 6-digit OTP
}

int main() {
    srand(time(0));
    string password, inputPwd;
    int otp, inputOtp;

    cout << "Enter password: ";
    cin >> inputPwd;

    // dummy password check
    if (inputPwd != "password123") {
        cout << "Invalid password\n";
        return 0;
    }

    otp = generateOTP();
    cout << "OTP sent: " << otp << endl; // in real system sent via SMS/app

    cout << "Enter received OTP: ";
    cin >> inputOtp;

    if (inputOtp == otp)
        cout << "Access granted\n";
    else
        cout << "Invalid OTP\n";

    cout << "\nLab no: 23";
    cout << "\nName: Samir Paudel";
    cout << "\nRoll No. / Section: 114-079/D\n";

    return 0;
}

