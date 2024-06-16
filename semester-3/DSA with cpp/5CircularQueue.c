#include <stdio.h>
#include <stdlib.h>

#define MAX 100

int circularQueue[MAX];
int front = -1, rear = -1;

// Function to enqueue an element in circular queue
void enqueue(int value) {
    if ((rear + 1) % MAX == front) {
        printf("Circular Queue overflow\n");
    } else {
        if (front == -1) front = 0;
        rear = (rear + 1) % MAX;
        circularQueue[rear] = value;
    }
}

// Function to dequeue an element from circular queue
int dequeue() {
    if (front == -1) {
        printf("Circular Queue underflow\n");
        return -1;
    } else {
        int value = circularQueue[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % MAX;
        }
        return value;
    }
}

// Function to display the circular queue
void display() {
    if (front == -1) {
        printf("Circular Queue is empty\n");
    } else {
        int i = front;
        while (1) {
            printf("%d ", circularQueue[i]);
            if (i == rear) break;
            i = (i + 1) % MAX;
        }
        printf("\n");
    }
}

int main() {
    int choice, value;
    
    while (1) {
        printf("\n1. Enqueue\n2. Dequeue\n3. Display\n4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);
        
        switch (choice) {
            case 1:
                printf("Enter value to enqueue: ");
                scanf("%d", &value);
                enqueue(value);
                break;
            case 2:
                value = dequeue();
                if (value != -1) {
                    printf("Dequeued value: %d\n", value);
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
Enter value to enqueue: 10
Enter your choice: 1
Enter value to enqueue: 20
Enter your choice: 3
Expected Output:
10 20
Enter your choice: 2
Dequeued value: 10
Enter your choice: 3
Expected Output:
20
Enter your choice: 4
*/
