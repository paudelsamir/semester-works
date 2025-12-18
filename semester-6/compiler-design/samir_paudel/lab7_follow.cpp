#include<stdio.h>
#include<string.h>
#include<ctype.h>

char prod[10][10];
int n;

void follow(char c, char result[], int *k) {
    int i, j;
    
    if(prod[0][0] == c)
        result[(*k)++] = '$';
    
    for(i = 0; i < n; i++) {
        for(j = 2; prod[i][j] != '\0'; j++) {
            if(prod[i][j] == c) {
                if(prod[i][j+1] != '\0') {
                    result[(*k)++] = prod[i][j+1];
                }
                else if(prod[i][0] != c) {
                    follow(prod[i][0], result, k);
                }
            }
        }
    }
}

int main() {
    char c, result[20];
    int i, k = 0;
    
    printf("Enter number of productions: ");
    scanf("%d", &n);
    
    printf("Enter productions (e.g., S=AB):\n");
    for(i = 0; i < n; i++) {
        scanf("%s", prod[i]);
    }
    
    printf("Enter symbol to find FOLLOW: ");
    scanf(" %c", &c);
    
    follow(c, result, &k);
    result[k] = '\0';
    
    printf("FOLLOW(%c) = { ", c);
    for(i = 0; i < k; i++) {
        printf("%c ", result[i]);
    }
    printf("}\n");
    
    printf("\nName: Samir Paudel\n");
    printf("Roll No: 114/079\n");
    printf("Lab No: 7\n");
    
    return 0;
}