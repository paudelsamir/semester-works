#include<stdio.h>
#include<string.h>

int main() {
    char str[200];
    
    printf("Enter a line: ");
    fgets(str, 200, stdin);
    
    if(str[0] == '/') {
        if(str[1] == '/')
            printf("Single line comment\n");
        else if(str[1] == '*')
            printf("Multi-line comment\n");
        else
            printf("Not a comment\n");
    }
    else {
        printf("Not a comment\n");
    }
    
    printf("\nName: Samir Paudel\n");
    printf("Roll No: 114/079\n");
    printf("Lab No: 5\n");
    
    return 0;
}