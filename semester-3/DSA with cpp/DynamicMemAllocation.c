#include <stdio.h>
#include <stdlib.h>

int main() {
    int n, *arr;
    
    printf("Enter number of elements: ");
    scanf("%d", &n);
    
    // Dynamic memory allocation
    arr = (int*)malloc(n * sizeof(int));
    
    if (arr == NULL) {
        printf("Memory not allocated.\n");
        exit(0);
    }
    
    printf("Enter elements:\n");
    for (int i = 0; i < n; ++i) {
        scanf("%d", &arr[i]);
    }
    
    printf("Elements in array are: ");
    for (int i = 0; i < n; ++i) {
        printf("%d ", arr[i]);
    }
    printf("\n");
    
    // Deallocating memory
    free(arr);
    
    return 0;
}

/*
Sample Input:
Enter number of elements: 5
Enter elements:
1 2 3 4 5

Expected Output:
Elements in array are: 1 2 3 4 5
*/
