#include<iostream>
using namespace std;

int S1[4][16] = {
    {14,4,13,1,2,15,11,8,3,10,6,12,5,9,0,7},
    {0,15,7,4,14,2,13,1,10,6,12,11,9,5,3,8},
    {4,1,14,8,13,6,2,11,15,12,9,7,3,10,5,0},
    {15,12,8,2,4,9,1,7,5,11,3,14,10,0,6,13}
};

int getS1Output(int input) {
    // input is 6 bits: bits 1 and 6 form row, bits 2-5 form col
    int row = ((input & 0x20) >> 4) | (input & 0x01);
    int col = (input & 0x1E) >> 1;
    return S1[row][col];
}

int main() {
    int input;
    cout << "Enter 6-bit input (0-63): ";
    cin >> input;
    if(input < 0 || input > 63) {
        cout << "Invalid input\n";
        return 1;
    }

    int output = getS1Output(input);
    cout << "S1 output (4-bit): " << output << endl;

    cout << "\nLab no: 11";
    cout << "\nName: Samir Paudel";
    cout << "\nRoll No. / Section: 114-079/D\n";

    return 0;
}

