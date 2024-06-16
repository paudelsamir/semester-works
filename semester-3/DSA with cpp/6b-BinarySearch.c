#include <stdio.h>

// Function for binary search
int binarySearch(int arr[], int left, int right, int key) {
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] < key) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
}

int main() {
    int n, key, result;
    
    // User input
    printf("Enter number of elements: ");
    scanf("%d", &n);
    
    int arr[n];
    printf("Enter sorted elements:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }
    
    printf("Enter element to search: ");
    scanf("%d", &key);
    
    result = binarySearch(arr, 0, n - 1, key);
    
    if (result != -1) {
        printf("Element found at index %d\n", result);
    } else {
        printf("Element not found\n");
    }
    
    return 0;
}

/*
Sample Input:
Enter number of elements: 5
Enter sorted elements:
10 20 30 40 50
Enter element to search: 30

Expected Output:
Element found at index 2
*/
