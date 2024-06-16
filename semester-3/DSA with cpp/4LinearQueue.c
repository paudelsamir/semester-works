#include <stdio.h>
#include <stdlib.h>

#define MAX 100

int queue[MAX], front = -1, rear = -1;

// Function to enqueue an element
void enqueue(int value) {
    if (rear == MAX - 1) {
        printf("Queue overflow\n");
    } else {
        if (front == -1)
            front = 0;
        queue[++rear] = value;
    }
}

// Function to dequeue an element
int dequeue() {
    if (front == -1 || front > rear) {
        printf("Queue underflow\n");
        return -1;
    } else {
        return queue[front++];
    }
}

// Function to display the queue
void display() {
    if (front == -1 || front > rear) {
        printf("Queue is empty\n");
    } else {
        for (int i = front; i <= rear; i++) {
            printf("%d ", queue[i]);
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
