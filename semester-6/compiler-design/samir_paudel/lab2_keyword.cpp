#include<stdio.h>
#include<string.h>
#include<ctype.h>

int main() {
    char str[50];
    char keywords[32][10] = {"auto","break","case","char","const","continue",
        "default","do","double","else","enum","extern","float","for","goto",
        "if","int","long","register","return","short","signed","sizeof",
        "static","struct","switch","typedef","union","unsigned","void",
        "volatile","while"};
    int i, flag = 0;
    
    printf("Enter string: ");
    scanf("%s", str);
    
    // Check if keyword
    for(i = 0; i < 32; i++) {
        if(strcmp(keywords[i], str) == 0) {
            printf("%s is a KEYWORD\n", str);
            flag = 1;
            break;
        }
    }
    
    // Check if valid identifier
    if(flag == 0) {
        if(isalpha(str[0]) || str[0] == '_') {
            for(i = 1; str[i] != '\0'; i++) {
                if(!isalnum(str[i]) && str[i] != '_') {
                    flag = 2;
                    break;
                }
            }
            if(flag == 2)
                printf("%s is INVALID\n", str);
            else
                printf("%s is a valid IDENTIFIER\n", str);
        }
        else
            printf("%s is INVALID\n", str);
    }
    
    printf("\nName: Samir Paudel\n");
    printf("Roll No: 114/079\n");
    printf("Lab No: 2\n");
    
    return 0;
}