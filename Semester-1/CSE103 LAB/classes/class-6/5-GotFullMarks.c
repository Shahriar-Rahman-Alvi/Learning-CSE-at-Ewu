#include <stdio.h>

int main()
{
    int temps[100], n, state = 0;
    printf("This program  can input some students' marks and check whether any student got full marks. You may assume that exam's total mark is 30.\nEnter the array length: ");
    scanf("%d", &n);
    if (n < 101)
    {
        for (int i = 0; i < n; i++)
        {
            printf("Enter day %d's temperature: ", i + 1);
            scanf("%d", &temps[i]);
            if (temps[i] == 30)
            {
                state++;
            }
        }
        printf("Anyone got full mark?\n");
        if (state > 0)
            printf("Yes");
        else
            printf("No");
    }
    else
        printf("Can't consider more than 100 length of array.");
    return 0;
}