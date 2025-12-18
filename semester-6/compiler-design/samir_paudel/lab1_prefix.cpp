#include<stdio.h>
#include<string.h>

int main() {
    char str[100];
    int i, j, len;
    
    printf("Enter string: ");
    scanf("%s", str);
    len = strlen(str);
    
    printf("\nPREFIXES:\n");
    for(i = 1; i <= len; i++) {
        for(j = 0; j < i; j++)
            printf("%c", str[j]);
        printf("\n");
    }
    
    printf("\nSUFFIXES:\n");
    for(i = 0; i < len; i++) {
        for(j = i; j < len; j++)
            printf("%c", str[j]);
        printf("\n");
    }
    
    printf("\nSUBSTRINGS:\n");
    for(i = 0; i < len; i++) {
        for(j = i; j < len; j++) {
            for(int k = i; k <= j; k++)
                printf("%c", str[k]);
            printf("\n");
        }
    }
    
    printf("\nName: Samir Paudel\n");
    printf("Roll No: 114/079\n");
    printf("Lab No: 1\n");
    
    return 0;
}