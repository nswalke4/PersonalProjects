# Menu-Based Program to Manipulate a List of Integers

<table>
<tr>
<th>Time to Complete</th>
<td>tbd</td>
</tr>
<tr>
<th>Date Completed</th>
<td>02/27/2023</td>
</tr>
</table>

<hr />

## Directions

Write a C++ Program that will allow a user to complete a variety of actions to manipulate a list of integers.  The menu options are as follows, and should accept both upper and lower case (first list level is the menu, second level is the action completed for each option):

- P - Print numbers
    - Display list as `[ # # ]` (if list is empty, display `[] - the list is empty`)
- A - Add a number
    - Prompt user for number to add, add that number, display `# added`
        - NOTE: After adding the additional functionality of not allowing duplicates, this funcitonality will need to check the list to ensure that the given value by the user is not already in the list if the user has selected to not allow duplicate numbers in their list.  If this occurs, it should display `Invalid option - No duplicates are allowed, and # is already a member of the list; Please enter a new number:` and allow the user to enter a new number to be added to the list.  This will repeat until the user enters a number that is not already in the list.
- M - Display mean of the numbers
    - Calculate mean and display `Mean: #` (if list is empty, display `Unable to calculate the mean - no data`)
- S - Display the smallest number
    - Find the smallest number and display `Min: #` (if list is empty, display `Unable to determine the smallest number - list is empty`)
- L - Display the largest number
    - Find the largest number and display `Max: #` (if list is empty, display `Unable to determine the largest number - list is empty`)
- Q - Quit
    - Display `Goodbye` and terminate the program

If an illegal choice is made, the program should display `Unknown selection, please try again` and repeat the display of the menu options.  The menu should repeat after each action has been completed until the user selects "Q" to quit the program.

## Additional Functionality to Extend This Program

There are some additional challenges that could be added to this program to extend its functionality (and this challenge):

- search for a number in the list and display the number of times that number appears in the list (could be 0)
- clearing out the list (reset with empty list)
- do not allow duplicate numbers

After considering the above challenges, I decided to add all three.  However, in order to best allow the "Search" functionality as well as the "no duplicate" functionality, I decided to implement the "no duplicates" as a switch for the user to either enable or disable.  This would allow the user to choose if they would like to include duplicate numbers or not.  The following are the new menu options to be added:

- D - Allow duplicate numbers?  (Currently `useDupes`)
    - Part of the `useDupes` boolean trigger.  Will display if the list is currently using duplicates or not.  NOTE: This option is only given to the user when the list is empty.  Displays `(Disa/A)llowing Duplicate Numbers` depending on the `useDupes` value.
- F - Find (useDupes ? "how many times" : "if") a number appears in the list
    - This is the search.  If `useDupes` is true, then the program will tell the user how many times the number is in the list (`# appears x number of time(s)`).  If `useDupes` is false, then it will tell the user if the number is in the list or not (`# is (not) in the list`).  
- C - Clear the list
    - Resets the list back to empty and displays `List Cleared`