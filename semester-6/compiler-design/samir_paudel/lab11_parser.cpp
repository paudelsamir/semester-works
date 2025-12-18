#include<stdio.h>
#include<string.h>

int main() {
    char stack[50], input[50], temp[3];
    int i = 0, j = 0;
    
    printf("Grammar production (E=E+E, E=id):\n");
    printf("Enter input string: ");
    scanf("%s", input);
    strcat(input, "$");
    
    stack[0] = '$';
    stack[1] = '\0';
    
    printf("\nStack\t\tInput\t\tAction\n");
    
    while(input[i] != '\0') {
        printf("%s\t\t%s\t\t", stack, &input[i]);
        
        // Shift
        j = strlen(stack);
        stack[j] = input[i];
        stack[j+1] = '\0';
        printf("Shift %c\n", input[i]);
        i++;
        
        // Simple reduction for id
        if(strlen(stack) >= 2 && stack[j] == 'd' && stack[j-1] == 'i') {
            stack[j-1] = 'E';
            stack[j] = '\0';
            printf("%s\t\t%s\t\tReduce id->E\n", stack, &input[i]);
        }
        
        if(strcmp(stack, "$E") == 0 && input[i] == '$') {
            printf("\nACCEPTED\n");
            break;
        }
    }
    
    printf("\nName: Samir Paudel\n");
    printf("Roll No: 114/079\n");
    printf("Lab No: 11\n");
    
    return 0;
}