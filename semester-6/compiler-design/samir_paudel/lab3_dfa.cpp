#include<stdio.h>
#include<string.h>

int main() {
    char str[100];
    int choice, i, len, state;
    
    printf("DFA Menu:\n");
    printf("1. Starts with 01\n");
    printf("2. Ends with 010\n");
    printf("3. Contains 011\n");
    printf("Enter choice: ");
    scanf("%d", &choice);
    
    printf("Enter string (0s and 1s): ");
    scanf("%s", str);
    len = strlen(str);
    
    if(choice == 1) {
        // Starts with 01
        if(len >= 2 && str[0] == '0' && str[1] == '1')
            printf("ACCEPTED\n");
        else
            printf("REJECTED\n");
    }
    else if(choice == 2) {
        // Ends with 010
        if(len >= 3 && str[len-3] == '0' && str[len-2] == '1' && str[len-1] == '0')
            printf("ACCEPTED\n");
        else
            printf("REJECTED\n");
    }
    else if(choice == 3) {
        // Contains 011
        state = 0;
        for(i = 0; i < len; i++) {
            if(state == 0 && str[i] == '0') state = 1;
            else if(state == 1 && str[i] == '1') state = 2;
            else if(state == 2 && str[i] == '1') state = 3;
            else if(state == 1 && str[i] == '0') state = 1;
            else if(state == 2 && str[i] == '0') state = 1;
        }
        if(state == 3)
            printf("ACCEPTED\n");
        else
            printf("REJECTED\n");
    }
    
    printf("\nName: Samir Paudel\n");
    printf("Roll No: 114/079\n");
    printf("Lab No: 3\n");
    
    return 0;
}