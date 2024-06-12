#include <stdio.h>
#include <stdlib.h>
/*
4 library functions provided by C under <stdlib.h> header file
1.malloc();
2.calloc();
3.free();
4.realloc();
*/
int main()
{
	int *ptr;
	int n, i;
	printf("Enter number of elements: ");
	scanf("%d", &n);

	// dynamically allocates memory by malloc
	ptr = (int *)malloc(n * sizeof(int));

	printf("Value is %d", *ptr);

	if (ptr == NULL)
	{
		printf("Memory not allocated\n");
		return 0;
	}
	else
	{
		printf("Memory created. Please enter n numbers");
		// reading numbers from user
		for (i = 0; i < n; i++)
		{
			scanf("%d", ptr + i);
		}

		// displaying numbers from array
		printf("Elements of array are: \n");
		for (i = 0; i < n; i++)
		{
			printf("%d\n", ptr[i]);
		}
		free(ptr);
	}

	return 0;
}
