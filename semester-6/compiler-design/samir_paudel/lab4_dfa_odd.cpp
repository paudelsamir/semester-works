#include<stdio.h>
#include<string.h>

int main() {
    char str[100];
    int i, count = 0;
    
    printf("Enter string (a's and b's): ");
    scanf("%s", str);
    
    for(i = 0; str[i] != '\0'; i++) {
        if(str[i] == 'a')
            count++;
    }
    
    if(count % 2 == 1)
        printf("ACCEPTED (Odd number of a's)\n");
    else
        printf("REJECTED (Even number of a's)\n");
    
    printf("\nName: Samir Paudel\n");
    printf("Roll No: 114/079\n");
    printf("Lab No: 4\n");
    
    return 0;
}