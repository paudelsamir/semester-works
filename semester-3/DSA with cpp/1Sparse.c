#include <stdio.h>

#define MAX_ROWS 100
#define MAX_COLS 100
#define MAX_NON_ZERO MAX_ROWS * MAX_COLS

void createSparseMatrix(int matrix[MAX_ROWS][MAX_COLS], int rows, int cols, int sparseMatrix[MAX_NON_ZERO][3]) {
    int k = 1;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (matrix[i][j] != 0) {
                sparseMatrix[k][0] = i;
                sparseMatrix[k][1] = j;
                sparseMatrix[k][2] = matrix[i][j];
                k++;
            }
        }
    }
    sparseMatrix[0][0] = rows;
    sparseMatrix[0][1] = cols;
    sparseMatrix[0][2] = k - 1;
}

void printSparseMatrix(int sparseMatrix[MAX_NON_ZERO][3]) {
    int nonZeroCount = sparseMatrix[0][2];

    printf("Sparse Matrix Representation:\n");
    printf("Rows: %d, Columns: %d, Non-Zero Count: %d\n", sparseMatrix[0][0], sparseMatrix[0][1], nonZeroCount);
    printf("Row Col Value\n");

    for (int i = 1; i <= nonZeroCount; i++) {
        printf("%3d %3d %4d\n", sparseMatrix[i][0], sparseMatrix[i][1], sparseMatrix[i][2]);
    }
}

int main() {
    int matrix[MAX_ROWS][MAX_COLS];
    int sparseMatrix[MAX_NON_ZERO][3] = {0};
    int rows, cols;

    printf("Enter number of rows and columns: ");
    scanf("%d %d", &rows, &cols);

    printf("Enter matrix elements:\n");
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            scanf("%d", &matrix[i][j]);
        }
    }

    createSparseMatrix(matrix, rows, cols, sparseMatrix);
    printSparseMatrix(sparseMatrix);

    return 0;
}

/*
Sample Input:
Enter number of rows and columns: 3 4
Enter matrix elements:
0 0 0 0
5 0 0 8
0 0 7 0

Expected Output:
Sparse Matrix Representation:
Rows: 3, Columns: 4, Non-Zero Count: 4
Row Col Value
  1   0    5
  1   3    8
  2   2    7
*/
