//1)  iii. program to form sparse matrix and print non-zero elements with its location :

#include <iostream>
using namespace std;

int main() {
    int rows, cols;
    cout << "Enter the number of rows and columns: ";
    cin >> rows >> cols;
    int matrix[rows][cols];
    cout << "Enter the elements of the matrix:" << endl;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            cin >> matrix[i][j];
        }
    }
    cout << "Non-zero elements and their positions:" << endl;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (matrix[i][j] != 0) {
                cout << "Element: " << matrix[i][j] << " at position (" << i << ", " << j << ")" << endl;
            }
        }
    }
     return 0;
}
