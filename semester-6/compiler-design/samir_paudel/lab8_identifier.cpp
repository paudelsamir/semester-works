#include<stdio.h>
#include<ctype.h>

int main() {
    char str[50];
    int i, valid = 1;
    
    printf("Enter identifier: ");
    scanf("%s", str);
    
    if(!isalpha(str[0]) && str[0] != '_') {
        valid = 0;
    }
    
    for(i = 1; str[i] != '\0'; i++) {
        if(!isalnum(str[i]) && str[i] != '_') {
            valid = 0;
            break;
        }
    }
    
    if(valid)
        printf("%s is VALID identifier\n", str);
    else
        printf("%s is INVALID identifier\n", str);
    
    printf("\nName: Samir Paudel\n");
    printf("Roll No: 114/079\n");
    printf("Lab No: 8\n");
    
    return 0;
}