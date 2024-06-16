#include <stdio.h>
#include <stdlib.h>

// Node structure
struct Node {
    int data;
    struct Node* next;
};

// Function to insert a node at the end
void insertAtEnd(struct Node** head_ref, int new_data) {
    struct Node* new_node = (struct Node*)malloc(sizeof(struct Node));
    struct Node *last = *head_ref;
    new_node->data = new_data;
    new_node->next = *head_ref;
    
    if (*head_ref == NULL) {
        *head_ref = new_node;
        new_node->next = *head_ref;
        return;
    }
    
    while (last->next != *head_ref) {
        last = last->next;
    }
    
    last->next = new_node;
}

// Function to delete a node by key
void deleteNode(struct Node** head_ref, int key) {
    if (*head_ref == NULL) return;
    
    struct Node *temp = *head_ref, *prev;
    
    if (temp != NULL && temp->data == key) {
        if (temp->next == *head_ref) {
            *head_ref = NULL;
            free(temp);
            return;
        }
        
        prev = *head_ref;
        while (prev->next != *head_ref) {
            prev = prev->next;
        }
        
        *head_ref = temp->next;
        prev->next = *head_ref;
        free(temp);
        return;
    }
    
    while (temp->next != *head_ref && temp->data != key) {
        prev = temp;
        temp = temp->next;
    }
    
    if (temp->data == key) {
        prev->next = temp->next;
        free(temp);
    }
}

// Function to print the circular linked list
void printList(struct Node* head) {
    struct Node* temp = head;
    if (head != NULL) {
        do {
            printf("%d -> ", temp->data);
            temp = temp->next;
        } while (temp != head);
    }
    printf("NULL\n");
}

int main() {
    struct Node* head = NULL;
    int choice, value;
    
    while (1) {
        printf("\n1. Insert at end\n2. Delete by value\n3. Display\n4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);
        
        switch (choice) {
            case 1:
                printf("Enter value to insert: ");
                scanf("%d", &value);
                insertAtEnd(&head, value);
                break;
            case 2:
                printf("Enter value to delete: ");
                scanf("%d", &value);
                deleteNode(&head, value);
                break;
            case 3:
                printList(head);
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
Enter value to insert: 10
Enter your choice: 1
Enter value to insert: 20
Enter your choice: 3
Expected Output:
10 -> 20 -> NULL
Enter your choice: 2
Enter value to delete: 10
Enter your choice: 3
Expected Output:
20 -> NULL
Enter your choice: 4
*/
