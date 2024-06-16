#include <stdio.h>

#define MAX 100

// Function to create a sparse matrix
void createSparseMatrix(int sparseMatrix[MAX][3], int matrix[MAX][MAX], int rows, int cols) {
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

// Function to print the sparse matrix
void printSparseMatrix(int sparseMatrix[MAX][3]) {
    printf("Sparse Matrix Representation:\n");
    for (int i = 0; i <= sparseMatrix[0][2]; i++) {
        printf("%d %d %d\n", sparseMatrix[i][0], sparseMatrix[i][1], sparseMatrix[i][2]);
    }
}

int main() {
    int matrix[MAX][MAX], sparseMatrix[MAX][3];
    int rows, cols;
    
    // User input
    printf("Enter number of rows and columns: ");
    scanf("%d %d", &rows, &cols);

    printf("Enter matrix elements:\n");
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            scanf("%d", &matrix[i][j]);
        }
    }

    createSparseMatrix(sparseMatrix, matrix, rows, cols);
    printSparseMatrix(sparseMatrix);

    return 0;
}

/*
Sample Input:
Enter number of rows and columns: 4 5
Enter matrix elements:
0 0 3 0 4
0 0 5 7 0
0 0 0 0 0
0 2 6 0 0

Expected Output:
Sparse Matrix Representation:
4 5 6
0 2 3
0 4 4
1 2 5
1 3 7
3 1 2
3 2 6
*/
