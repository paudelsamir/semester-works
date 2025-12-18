#include<stdio.h>
#include<string.h>

struct symbol {
    char name[20];
    int addr;
    char type[10];
} s[10];

int main() {
    int n, i, found = 0;
    char search[20];
    
    printf("Enter number of symbols: ");
    scanf("%d", &n);
    
    printf("Enter symbols (name address type):\n");
    for(i = 0; i < n; i++) {
        scanf("%s %d %s", s[i].name, &s[i].addr, s[i].type);
    }
    
    printf("\nSymbol Table:\n");
    printf("Name\tAddress\tType\n");
    for(i = 0; i < n; i++) {
        printf("%s\t%d\t%s\n", s[i].name, s[i].addr, s[i].type);
    }
    
    printf("\nEnter symbol to search: ");
    scanf("%s", search);
    
    for(i = 0; i < n; i++) {
        if(strcmp(s[i].name, search) == 0) {
            printf("Found: %s at address %d, type %s\n", s[i].name, s[i].addr, s[i].type);
            found = 1;
            break;
        }
    }
    
    if(!found)
        printf("Symbol not found\n");
    
    printf("\nName: Samir Paudel\n");
    printf("Roll No: 114/079\n");
    printf("Lab No: 10\n");
    
    return 0;
}