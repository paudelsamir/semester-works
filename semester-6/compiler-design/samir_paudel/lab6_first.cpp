#include<stdio.h>
#include<string.h>
#include<ctype.h>

char prod[10][10];
int n;

void first(char c, char result[]) {
    int i, j, k = 0;
    
    if(!isupper(c)) {
        result[k++] = c;
        result[k] = '\0';
        return;
    }
    
    for(i = 0; i < n; i++) {
        if(prod[i][0] == c) {
            if(!isupper(prod[i][2])) {
                result[k++] = prod[i][2];
            }
            else {
                first(prod[i][2], result);
                return;
            }
        }
    }
    result[k] = '\0';
}

int main() {
    char c, result[20];
    int i;
    
    printf("Enter number of productions: ");
    scanf("%d", &n);
    
    printf("Enter productions (e.g., A=aB):\n");
    for(i = 0; i < n; i++) {
        scanf("%s", prod[i]);
    }
    
    printf("Enter symbol to find FIRST: ");
    scanf(" %c", &c);
    
    first(c, result);
    
    printf("FIRST(%c) = { ", c);
    for(i = 0; result[i] != '\0'; i++) {
        printf("%c ", result[i]);
    }
    printf("}\n");
    
    printf("\nName: Samir Paudel\n");
    printf("Roll No: 114/079\n");
    printf("Lab No: 6\n");
    
    return 0;
}