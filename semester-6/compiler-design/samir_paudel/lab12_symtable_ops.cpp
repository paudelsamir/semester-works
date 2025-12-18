#include <stdio.h>
#include <string.h>

#define MAX 10

struct symbol {
    char label[20];
    int addr;
} s[MAX];

int count = 0;

void insert() {
    char l[20];
    int a, i;

    if (count >= MAX) {
        printf("symbol table full\n");
        return;
    }

    printf("enter label: ");
    scanf("%19s", l);

    for (i = 0; i < count; i++) {
        if (strcmp(s[i].label, l) == 0) {
            printf("duplicate symbol\n");
            return;
        }
    }

    printf("enter address: ");
    scanf("%d", &a);

    strcpy(s[count].label, l);
    s[count].addr = a;
    count++;

    printf("inserted\n");
}

void display() {
    int i;

    if (count == 0) {
        printf("symbol table empty\n");
        return;
    }

    printf("\nlabel\taddress\n");
    for (i = 0; i < count; i++) {
        printf("%s\t%d\n", s[i].label, s[i].addr);
    }
}

void delete_symbol() {
    char l[20];
    int i, j, found = 0;

    printf("enter label to delete: ");
    scanf("%19s", l);

    for (i = 0; i < count; i++) {
        if (strcmp(s[i].label, l) == 0) {
            found = 1;
            for (j = i; j < count - 1; j++) {
                s[j] = s[j + 1];
            }
            count--;
            printf("deleted\n");
            break;
        }
    }

    if (!found)
        printf("label not found\n");
}

void search() {
    char l[20];
    int i;

    printf("enter label to search: ");
    scanf("%19s", l);

    for (i = 0; i < count; i++) {
        if (strcmp(s[i].label, l) == 0) {
            printf("found at address: %d\n", s[i].addr);
            return;
        }
    }

    printf("not found\n");
}

void modify() {
    char l[20];
    int i;

    printf("enter label to modify: ");
    scanf("%19s", l);

    for (i = 0; i < count; i++) {
        if (strcmp(s[i].label, l) == 0) {
            printf("enter new address: ");
            scanf("%d", &s[i].addr);
            printf("modified\n");
            return;
        }
    }

    printf("not found\n");
}

int main() {
    int choice;

    while (1) {
        printf("\n1.insert 2.display 3.delete 4.search 5.modify 6.exit\n");
        printf("choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1: insert(); break;
            case 2: display(); break;
            case 3: delete_symbol(); break;
            case 4: search(); break;
            case 5: modify(); break;
            case 6:
                printf("\nname: samir paudel\n");
                printf("roll no: 114/079\n");
                printf("lab no: 12\n");
                return 0;
            default:
                printf("invalid choice\n");
        }
    }
}
