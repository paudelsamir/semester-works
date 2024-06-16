#include <stdio.h>
#include <stdlib.h>

// Node structure
struct Node {
    int data;
    struct Node* next;
    struct Node* prev;
};

// Function to insert a node at the beginning
void insertAtBeginning(struct Node** head_ref, int new_data) {
    struct Node* new_node = (struct Node*)malloc(sizeof(struct Node));
    new_node->data = new_data;
    new_node->next = (*head_ref);
    new_node->prev = NULL;
    if ((*head_ref) != NULL) {
        (*head_ref)->prev = new_node;
    }
    (*head_ref) = new_node;
}

// Function to delete a node by key
void deleteNode(struct Node** head_ref, int key) {
    struct Node* temp = *head_ref;
    
    while (temp != NULL && temp->data != key) {
        temp = temp->next;
    }
    
    if (temp == NULL) return;
    
    if (*head_ref == temp) {
        *head_ref = temp->next;
    }
    
    if (temp->next != NULL) {
        temp->next->prev = temp->prev;
    }
    
    if (temp->prev != NULL) {
        temp->prev->next = temp->next;
    }
    
    free(temp);
}

// Function to print the linked list
void printList(struct Node* node) {
    struct Node* last;
    printf("Forward traversal: ");
    while (node != NULL) {
        printf("%d -> ", node->data);
        last = node;
        node = node->next;
    }
    printf("NULL\n");
    
    printf("Backward traversal: ");
    while (last != NULL) {
        printf("%d -> ", last->data);
        last = last->prev;
    }
    printf("NULL\n");
}

int main() {
    struct Node* head = NULL;
    int choice, value;
    
    while (1) {
        printf("\n1. Insert at beginning\n2. Delete by value\n3. Display\n4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);
        
        switch (choice) {
            case 1:
                printf("Enter value to insert: ");
                scanf("%d", &value);
                insertAtBeginning(&head, value);
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
Forward traversal: 20 -> 10 -> NULL
Backward traversal: 10 -> 20 -> NULL
Enter your choice: 2
Enter value to delete: 10
Enter your choice: 3
Expected Output:
Forward traversal: 20 -> NULL
Backward traversal: 20 -> NULL
Enter your choice: 4
*/
