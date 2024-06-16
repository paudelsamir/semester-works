#include <stdio.h>
#include <stdlib.h>

#define MAX 100

int stack[MAX], top = -1;

// Function to push an element onto the stack
void push(int value) {
    if (top == MAX - 1) {
        printf("Stack overflow\n");
    } else {
        stack[++top] = value;
    }
}

// Function to pop an element from the stack
int pop() {
    if (top == -1) {
        printf("Stack underflow\n");
        return -1;
    } else {
        return stack[top--];
    }
}

// Function to display the stack
void display() {
    if (top == -1) {
        printf("Stack is empty\n");
    } else {
        for (int i = top; i >= 0; i--) {
            printf("%d ", stack[i]);
        }
        printf("\n");
    }
}

int main() {
    int choice, value;
    
    while (1) {
        printf("\n1. Push\n2. Pop\n3. Display\n4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);
        
        switch (choice) {
            case 1:
                printf("Enter value to push: ");
                scanf("%d", &value);
                push(value);
                break;
            case 2:
                value = pop();
                if (value != -1) {
                    printf("Popped value: %d\n", value);
                }
                break;
            case 3:
                display();
                break;
            case 4:
                exit(0);
            default:
                printf("Invalid choice\n");
        }
    }
    return 0;
}

/*
Sample Input:
Enter your choice: 1
Enter value to push: 10
Enter your choice: 1
Enter value to push: 20
Enter your choice: 3
Expected Output:
20 10
Enter your choice: 2
Popped value: 20
Enter your choice: 3
Expected Output:
10
Enter your choice: 4
*/
