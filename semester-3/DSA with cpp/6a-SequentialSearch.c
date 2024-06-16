#include <stdio.h>

// Function for sequential search
int sequentialSearch(int arr[], int n, int key) {
    for (int i = 0; i < n; i++) {
        if (arr[i] == key) {
            return i;
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
    printf("Enter elements:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }
    
    printf("Enter element to search: ");
    scanf("%d", &key);
    
    result = sequentialSearch(arr, n, key);
    
    if (result != -1) {
        printf("Element found at index %d\n", result);
    } else {
        printf("Element not found\n");
    }
    
    return 0;
}

// #include <stdio.h>

// // Function for sequential search (linear search)
// int sequentialSearch(int arr[], int n, int target) {
//     for (int i = 0; i < n; i++)
//         if (arr[i] == target)
//             return i;
//     return -1;
// }

// // Example usage
// int main() {
//     int arr[] = {10, 20, 30, 40, 50};
//     int n = sizeof(arr) / sizeof(arr[0]);
//     int target = 30;

//     int index = sequentialSearch(arr, n, target);

//     if (index != -1)
//         printf("Element %d found at index %d.\n", target, index);
//     else
//         printf("Element %d not found in the array.\n", target);

//     return 0;
// }

/*
Sample Input:
Enter number of elements: 5
Enter elements:
10 20 30 40 50
Enter element to search: 30

Expected Output:
Element found at index 2
*/
