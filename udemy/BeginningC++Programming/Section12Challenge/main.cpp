/**
 * @file main.cpp
 * @author Nicholas Walker
 * @date 03/01/2023
 *
 * @brief Practice with pointers and functions by using the address of two
 *        arrays to create and return the address of a new array.
 */

#include <iostream>

using namespace std;

int* apply_all(int*, size_t, int*, size_t);

void print(int*, size_t);

int main(int argc, char *argv[])
{
    int arr1[] {1,2,3,4,5};
    int arr2[] {10,20,30};
    int *results {nullptr};

    cout << "Array 1: ";
    print(arr1, 5);
    cout << "Array 2: ";
    print(arr2, 3);
    results = apply_all(arr1, 5, arr2, 3);
    cout << "Results: ";
    print(results, 15);
    return 0;
}

int* apply_all(int* arr1, size_t arr1Size, int* arr2, size_t arr2Size)
{
    size_t newSize {arr1Size * arr2Size};
    int *returnPtr {nullptr};
    returnPtr = new int[newSize];
    size_t i = 0;
    for (size_t j = 0; j < arr2Size; j++)
        for (size_t k = 0; k < arr1Size; k++)
        {
            *(returnPtr + i) = *(arr2 + j) * *(arr1 + k);
            i++;
        }

    return returnPtr;
}

void print(int* arr, size_t size)
{
    cout << "[ ";
    for (size_t i = 0; i < size; i++)
        cout << *(arr + i) << " ";
    cout << "]" << endl;
}
