#include <iostream>
#include <vector>
using namespace std;

bool isSafe(vector<vector<int>> &board, int row, int col, int N) {
    // Check column
    for (int i = 0; i < row; i++) {
        if (board[i][col] == 1) return false;
    }
    // Check left diagonal
    for (int i = row -1, j = col -1; i >=0 && j >=0; i--, j--) {
        if (board[i][j] == 1) return false;
    }
    // Check right diagonal
    for (int i = row -1, j = col +1; i >=0 && j < N; i--, j++) {
        if (board[i][j] == 1) return false;
    }
    return true;
}

bool solveNQueenUtil(vector<vector<int>> &board, int row, int N) {
    if (row == N) return true; // all queens placed

    for (int col = 0; col < N; col++) {
        if (isSafe(board, row, col, N)) {
            board[row][col] = 1;
            if (solveNQueenUtil(board, row + 1, N)) return true;
            board[row][col] = 0; // backtrack
        }
    }
    return false; // no position found
}

int main() {
    int N;
    cout << "Enter the value of N: ";
    cin >> N;

    if (N < 4) {
        cout << "Solution Does Not Exist" << endl;
    } else {
        vector<vector<int>> board(N, vector<int>(N, 0));

        if (solveNQueenUtil(board, 0, N)) {
            cout << "One of the possible solutions:" << endl;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cout << board[i][j] << " ";
                }
                cout << endl;
            }
        } else {
            cout << "Solution Does Not Exist" << endl;
        }
    }

    cout << "\nLab No.: 11(c)" << endl;
    cout << "Name: Samir Paudel" << endl;
    cout << "Roll No./Section: 114-079/D" << endl;

    return 0;
}