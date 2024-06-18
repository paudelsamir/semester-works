#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};

void insertAtPosition(struct Node** head, int data, int pos) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    if (pos == 1) {
        newNode->next = *head;  
        *head = newNode;
    } else {
        struct Node* temp = *head;
        for (int i = 1; temp != NULL && i < pos - 1; i++) temp = temp->next;
        if (temp != NULL) {
            newNode->next = temp->next;
            temp->next = newNode;
        } else {
            free(newNode);
            return;
        }
    }
    printList(*head); // Automatically print list after insertion
}

void deleteAtPosition(struct Node** head, int pos) {
    if (*head == NULL) return;
    struct Node* temp = *head;
    if (pos == 1) {
        *head = temp->next;
        free(temp);
    } else {
        struct Node* prev = NULL;
        for (int i = 1; temp != NULL && i < pos; i++) {
            prev = temp;
            temp = temp->next;
        }
        if (temp != NULL) {
            prev->next = temp->next;
            free(temp);
        } else {
            return;
        }
    }
    printList(*head); // Automatically print list after deletion
}

void printList(struct Node* head) {
    while (head != NULL) {
        printf("%d -> ", head->data);
        head = head->next;
    }
    printf("NULL\n");
}

void freeList(struct Node** head) {
    struct Node* temp;
    while (*head != NULL) {
        temp = *head;
        *head = (*head)->next;
        free(temp);
    }
}

int main() {
    struct Node* head = NULL;
    int choice, data, pos;

    while (1) {
        printf("\n1. Insert\n2. Delete\n3. Exit\nEnter choice: ");
        scanf("%d", &choice);
        if (choice == 3) break;
        if (choice == 1) {
            printf("Enter data and position: ");
            scanf("%d %d", &data, &pos);
            insertAtPosition(&head, data, pos);
        } else if (choice == 2) {
            printf("Enter position: ");
            scanf("%d", &pos);
            deleteAtPosition(&head, pos);
        } else {
            printf("Invalid choice\n");
        }
    }

    freeList(&head);
    return 0;
}
