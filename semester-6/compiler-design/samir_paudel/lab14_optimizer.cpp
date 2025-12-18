#include<stdio.h>
#include<string.h>

struct quad {
    char op[10];
    char arg1[10];
    char arg2[10];
    char result[10];
    int live;
} q[20];

int n;

void readTAC() {
    printf("Enter number of TAC statements: ");
    scanf("%d", &n);
    
    printf("Enter TAC (op arg1 arg2 result):\n");
    for(int i = 0; i < n; i++) {
        scanf("%s %s %s %s", q[i].op, q[i].arg1, q[i].arg2, q[i].result);
        q[i].live = 1;
    }
}

void eliminateDeadCode() {
    for(int i = 0; i < n; i++) { // check all statements, including last
        int used = 0;
        for(int j = i + 1; j < n; j++) {
            if(strcmp(q[j].arg1, q[i].result) == 0 || 
               strcmp(q[j].arg2, q[i].result) == 0) {
                used = 1;
                break;
            }
        }
        if(!used && strcmp(q[i].op, "=") == 0) {
            q[i].live = 0;
        }
    }
}

void display() {
    printf("\nOptimized TAC:\n");
    for(int i = 0; i < n; i++) {
        if(q[i].live) {
            printf("%s %s %s %s\n", q[i].op, q[i].arg1, q[i].arg2, q[i].result);
        }
    }
}

int main() {
    readTAC();
    eliminateDeadCode();
    display();
    
    printf("\nName: Samir Paudel\n");
    printf("Roll No: 114/079\n");
    printf("Lab No: 14\n");
    
    return 0;
}
