#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

#define MAX 100

char stack[MAX];
int top = -1;

void push(char item) {
    if (top >= MAX - 1) {
        printf("Stack overflow\n");
    } else {
        stack[++top] = item;
    }
}

char pop() {
    if (top < 0) {
        printf("Stack underflow\n");
        return -1;
    } else {
        return stack[top--];
    }
}

int precedence(char symbol) {
    switch (symbol) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        case '^':
            return 3;
        default:
            return 0;
    }
}

void infixToPostfix(char infix[], char postfix[]) {
    int i = 0, j = 0;
    char item;
    
    while (infix[i] != '\0') {
        item = infix[i];
        
        if (isalnum(item)) {
            postfix[j++] = item;
        } else if (item == '(') {
            push(item);
        } else if (item == ')') {
            while (stack[top] != '(') {
                postfix[j++] = pop();
            }
            pop();  // pop '('
        } else {
            while (precedence(stack[top]) >= precedence(item)) {
                postfix[j++] = pop();
            }
            push(item);
        }
        i++;
    }
    
    while (top != -1) {
        postfix[j++] = pop();
    }
    
    postfix[j] = '\0';
}

int main() {
    char infix[MAX], postfix[MAX];
    
    printf("Enter infix expression: ");
    scanf("%s", infix);
    
    infixToPostfix(infix, postfix);
    
    printf("Postfix expression: %s\n", postfix);
    
    return 0;
}

/*
Sample Input:
Enter infix expression: a+b*c

Expected Output:
Postfix expression: abc*+
*/
