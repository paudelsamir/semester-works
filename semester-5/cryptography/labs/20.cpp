#include <iostream>
#include <cstring>
#include <cstdint>
using namespace std;

typedef uint32_t uint4;

// leftrotate function
uint4 leftRotate(uint4 x, uint4 n) {
    return (x << n) | (x >> (32 - n));
}

class MD4 {
    uint4 A, B, C, D;
    uint4 X[16];
    void processBlock(const unsigned char block[64]) {
        for (int i = 0; i < 16; ++i) {
            X[i] = (uint4)block[i * 4] | ((uint4)block[i * 4 + 1] << 8) |
                   ((uint4)block[i * 4 + 2] << 16) | ((uint4)block[i * 4 + 3] << 24);
        }

        uint4 AA = A, BB = B, CC = C, DD = D;

        // Round 1
        #define F(x,y,z) ((x & y) | (~x & z))
        #define STEP1(a,b,c,d,k,s) a = leftRotate(a + F(b,c,d) + X[k], s)

        STEP1(A,B,C,D,0,3); STEP1(D,A,B,C,1,7); STEP1(C,D,A,B,2,11); STEP1(B,C,D,A,3,19);
        STEP1(A,B,C,D,4,3); STEP1(D,A,B,C,5,7); STEP1(C,D,A,B,6,11); STEP1(B,C,D,A,7,19);
        STEP1(A,B,C,D,8,3); STEP1(D,A,B,C,9,7); STEP1(C,D,A,B,10,11); STEP1(B,C,D,A,11,19);
        STEP1(A,B,C,D,12,3); STEP1(D,A,B,C,13,7); STEP1(C,D,A,B,14,11); STEP1(B,C,D,A,15,19);

        // Round 2
        #undef F
        #define G(x,y,z) ((x & y) | (x & z) | (y & z))
        #define STEP2(a,b,c,d,k,s) a = leftRotate(a + G(b,c,d) + X[k] + 0x5a827999, s)

        STEP2(A,B,C,D,0,3); STEP2(D,A,B,C,4,5); STEP2(C,D,A,B,8,9); STEP2(B,C,D,A,12,13);
        STEP2(A,B,C,D,1,3); STEP2(D,A,B,C,5,5); STEP2(C,D,A,B,9,9); STEP2(B,C,D,A,13,13);
        STEP2(A,B,C,D,2,3); STEP2(D,A,B,C,6,5); STEP2(C,D,A,B,10,9); STEP2(B,C,D,A,14,13);
        STEP2(A,B,C,D,3,3); STEP2(D,A,B,C,7,5); STEP2(C,D,A,B,11,9); STEP2(B,C,D,A,15,13);

        // Round 3
        #undef G
        #define H(x,y,z) (x ^ y ^ z)
        #define STEP3(a,b,c,d,k,s) a = leftRotate(a + H(b,c,d) + X[k] + 0x6ed9eba1, s)

        STEP3(A,B,C,D,0,3); STEP3(D,A,B,C,8,9); STEP3(C,D,A,B,4,11); STEP3(B,C,D,A,12,15);
        STEP3(A,B,C,D,2,3); STEP3(D,A,B,C,10,9); STEP3(C,D,A,B,6,11); STEP3(B,C,D,A,14,15);
        STEP3(A,B,C,D,1,3); STEP3(D,A,B,C,9,9); STEP3(C,D,A,B,5,11); STEP3(B,C,D,A,13,15);
        STEP3(A,B,C,D,3,3); STEP3(D,A,B,C,11,9); STEP3(C,D,A,B,7,11); STEP3(B,C,D,A,15,15);

        A += AA; B += BB; C += CC; D += DD;
    }

public:
    MD4() : A(0x67452301), B(0xefcdab89), C(0x98badcfe), D(0x10325476) {}

    void update(const unsigned char* msg, size_t length) {
        size_t i;
        for (i = 0; i + 64 <= length; i += 64) {
            processBlock(msg + i);
        }

        unsigned char block[64] = {0};
        size_t rem = length - i;
        memcpy(block, msg + i, rem);
        block[rem] = 0x80;

        if (rem >= 56) {
            processBlock(block);
            memset(block, 0, 64);
        }

        uint64_t bitLen = length * 8;
        for (int j = 0; j < 8; ++j) {
            block[56 + j] = (bitLen >> (8 * j)) & 0xff;
        }
        processBlock(block);
    }

    void digest(unsigned char output[16]) {
        for (int i = 0; i < 4; i++) {
            output[i] = (A >> (8 * i)) & 0xff;
            output[i + 4] = (B >> (8 * i)) & 0xff;
            output[i + 8] = (C >> (8 * i)) & 0xff;
            output[i + 12] = (D >> (8 * i)) & 0xff;
        }
    }
};

string toHex(const unsigned char* data, size_t length) {
    const char* hex = "0123456789abcdef";
    string s;
    for (size_t i = 0; i < length; i++) {
        s += hex[(data[i] >> 4) & 0xF];
        s += hex[data[i] & 0xF];
    }
    return s;
}

int main() {
    string input;
    cout << "Enter message to hash: ";
    getline(cin, input);

    MD4 md4;
    md4.update(reinterpret_cast<const unsigned char*>(input.c_str()), input.size());

    unsigned char hash[16];
    md4.digest(hash);

    cout << "MD4 Hash: " << toHex(hash, 16) << endl;

    cout << "\nLab no: 20";
    cout << "\nName: Samir Paudel";
    cout << "\nRoll No. / Section: 114-079/D\n";

    return 0;
}
