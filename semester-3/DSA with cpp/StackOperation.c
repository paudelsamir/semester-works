#include <stdio.h>
#include <stdlib.h>

#define MAX 100

int stack[MAX];
int top = -1;

void push(int value) {
    if (top == MAX - 1) {
        printf("Stack overflow\n");
    } else {
        top++;
        stack[top] = value;
    }
}

void pop() {
    if (top == -1) {
        printf("Stack underflow\n");
    } else {
        printf("Popped element: %d\n", stack[top]);
        top--;
    }
}

void display() {
    if (top == -1) {
        printf("Stack is empty\n");
    } else {
        printf("Stack elements: ");
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
                pop();
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
Stack elements: 20 10
Enter your choice: 2
Expected Output:
Popped element: 20
Enter your choice: 3
Expected Output:
Stack elements: 10
Enter your choice: 4
*/
