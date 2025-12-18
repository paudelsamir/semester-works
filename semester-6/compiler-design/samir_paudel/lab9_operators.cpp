#include<stdio.h>
#include<string.h>

int main() {
    char str[50];
    char operators[] = "+-*/%=<>!&|";
    int i, found = 0;
    
    printf("Enter operator: ");
    scanf("%s", str);
    
    for(i = 0; i < strlen(operators); i++) {
        if(str[0] == operators[i]) {
            found = 1;
            break;
        }
    }
    
    if(found)
        printf("%s is a valid OPERATOR\n", str);
    else
        printf("%s is NOT a valid OPERATOR\n", str);
    
    printf("\nName: Samir Paudel\n");
    printf("Roll No: 114/079\n");
    printf("Lab No: 9\n");
    
    return 0;
}