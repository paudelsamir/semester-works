#include<stdio.h>
#include<string.h>
#include<ctype.h>

char stack[50];
int top = -1;
int temp_count = 1;

void push(char c) {
    stack[++top] = c;
}

char pop() {
    return stack[top--];
}

int precedence(char c) {
    if(c == '*' || c == '/') return 2;
    if(c == '+' || c == '-') return 1;
    return 0;
}

void infixToPostfix(char infix[], char postfix[]) {
    int i = 0, j = 0;
    char c;
    
    while(infix[i] != '\0') {
        c = infix[i];
        
        if(isalnum(c)) {
            postfix[j++] = c;
        }
        else if(c == '(') {
            push(c);
        }
        else if(c == ')') {
            while(stack[top] != '(') {
                postfix[j++] = pop();
            }
            pop(); // remove '('
        }
        else {
            while(top != -1 && precedence(stack[top]) >= precedence(c)) {
                postfix[j++] = pop();
            }
            push(c);
        }
        i++;
    }
    
    while(top != -1) {
        postfix[j++] = pop();
    }
    postfix[j] = '\0';
}

void generateTAC(char postfix[]) {
    char op_stack[50][10];
    int op_top = -1;
    int i;
    char temp[10];
    
    printf("\nThree Address Code:\n");
    
    for(i = 0; postfix[i] != '\0'; i++) {
        if(isalnum(postfix[i])) {
            sprintf(temp, "%c", postfix[i]);
            strcpy(op_stack[++op_top], temp);
        }
        else {
            char arg2[10], arg1[10], result[10];
            strcpy(arg2, op_stack[op_top--]);
            strcpy(arg1, op_stack[op_top--]);
            sprintf(result, "t%d", temp_count++);
            
            printf("%c, %s, %s, %s\n", postfix[i], arg1, arg2, result);
            strcpy(op_stack[++op_top], result);
        }
    }
}

int main() {
    char infix[50], postfix[50];
    
    printf("Enter infix expression: ");
    scanf("%s", infix);
    
    infixToPostfix(infix, postfix);
    printf("Postfix: %s\n", postfix);
    
    generateTAC(postfix);
    
    printf("\nName: Samir Paudel\n");
    printf("Roll No: 114/079\n");
    printf("Lab No: 13\n");
    
    return 0;
}