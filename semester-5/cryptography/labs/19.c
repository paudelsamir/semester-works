#include <iostream>
#include <fstream>
#include <cstdlib>
#include <string>
using namespace std;

int main() {
    cout << "Welcome to this harmless program!\n";

    for (int i = 0; i < 5; i++) {
        string filename = "junkfile" + to_string(i) + ".txt";
        ofstream f(filename);
        f << "this is junk data\n";
        f.close();
    }
    }

    cout << "Created junk files to simulate malicious behavior.\n";

    cout << "\nLab no: 19";
    cout << "\nName: Samir Paudel";
    cout << "\nRoll No. / Section: 114-079/D\n";

    return 0;
}

