/*
Author: Nick Walker
Date: 06-20-22
Purpose: This file was created to test how arrays are initialied at creation in C.
*/

#include <stdio.h>

#define SIZE 5

int main(int argc, char *argv) {

    int arr1[SIZE];
    int arr2[SIZE] = {};
    int arr3[SIZE] = {0};
    int arr4[SIZE] = {1};

    int i;

    printf("\nThis file shows how initialization works for arrays in C.\n\n");
    printf("  - Arr1 has no initalization (int arr[n];)\n");
    printf("  - Arr2 has empty initalization (int arr[n] = {};)\n");
    printf("  - Arr3 has single 0 initalization (int arr[n] = {0};)\n");
    printf("  - Arr4 has single 1 initalization (int arr[n] = {1};)\n\n");
    printf("-----------------------------------------------------------------\n");
    printf("| i |     Arr1     |     Arr2     |     Arr3     |     Arr4     |\n");
    printf("|---|--------------|--------------|--------------|--------------|\n");
    for (i=0; i < SIZE; i++) {
        printf("| %d | %12d | %12d | %12d | %12d |\n", i, arr1[i], arr2[i], arr3[i], arr4[i]);
    }
    printf("-----------------------------------------------------------------\n");
    printf("\n\n~~End of Array Initalization Examples in C~~\n\n");

    return 0;
}