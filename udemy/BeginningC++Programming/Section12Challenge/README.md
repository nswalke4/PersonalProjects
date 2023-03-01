# Practice with Pointers and Functions

<table>
<tr>
<th>Time to Complete</th>
<td>tbd</td>
</tr>
<tr>
<th>Date Completed</th>
<td>03/01/2023</td>
</tr>
</table>

<hr />

## Directions

Write a C++ function named `apply_all` that expects two arrays of integers and their sizes and dynamically allocates a new array of integers whose size is the product of the 2 array sizes.  The function should loop through the second array and multiply each element across each element of array 1 and store the product in the newly created array.  The function should return a pointer to the newly allocated array.  You can also write a print function that expects a pointer to an array of integers and its size and display the elements in the array.

### Example

```
    int array1[] {1,2,3,4,5};
    int array2[] {10,20,30};

    cout << "Array 1: ";
    print(array1,5);

    cout << "Array 2: ";
    print(array2,3);

    int *results = apply_all(array1, 5, array2, 3);
    cout << "Results: ";
    print(results,15);
```
```
    OUTPUT
    ------
    Array 1: [ 1 2 3 4 5 ]
    Array 2: [ 10 20 30 ]
    Results: [ 10 20 30 40 50 20 40 60 80 100 30 60 90 120 150 ]
```
