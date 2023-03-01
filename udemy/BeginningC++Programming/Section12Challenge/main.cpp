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

int* apply_all(const int *const, const size_t, const int *const, const size_t);

void print(const int *const, const size_t);

int main(int argc, char *argv[])
{
    const int arr1Size {5};
    const int arr2Size {3};
    int arr1[] {1,2,3,4,5};
    int arr2[] {10,20,30};
    int *results {nullptr};

    cout << "Array 1: ";
    print(arr1, arr1Size);
    cout << "Array 2: ";
    print(arr2, arr2Size);
    results = apply_all(arr1, arr1Size, arr2, arr2Size);
    cout << "Results: ";
    print(results, arr1Size*arr2Size);
    return 0;
}

int* apply_all(const int *const arr1, const size_t arr1Size, const int *const arr2, const size_t arr2Size)
{
    const size_t newSize {arr1Size * arr2Size};
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

void print(const int *const arr, const size_t size)
{
    cout << "[ ";
    for (size_t i = 0; i < size; i++)
        cout << *(arr + i) << " ";
    cout << "]" << endl;
}
