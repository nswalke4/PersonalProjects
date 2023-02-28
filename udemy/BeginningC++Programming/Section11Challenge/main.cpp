/**
 * @file main.cpp
 * @author Nicholas Walker
 * @date 02/28/2023
 *
 * @brief Modularize the Section 9 Challenge Solution
 */

#include <iostream>
#include <iomanip>
#include <algorithm>
#include <vector>

using namespace std;

// This is the solution from Section 9's challenge which will be modularized
int section9ChallengeSolution()
{
    bool quit {false};
    bool useDupes {false};
    char menuSelection {};
    vector<int> list {};

    string mostChoices {};

    cout << boolalpha;
    while (!quit) {
        cout << "\n\n+---------+\n|Main Menu|\n+---------+";
        if (list.size() == 0)
            cout << "\nD - Allow Duplicate Numbers? Currently " << useDupes;
        cout << "\nP - Print numbers\nA - Add a number\nF - Find a number\n";
        cout << "M - Display mean of the numbers\nS - Display the smallest number\n";
        cout << "L - Display the largest number\nC - Clear the List\nQ - Quit\n";
        cout << "\nEnter your choice >> ";
        cin >> menuSelection;
        switch (menuSelection) {
            case 'a':
            case 'A':
                {
                    bool validNum {false};
                    int addedNum {};
                    do
                    {
                        cout << "\nEnter the number you wish to add to the list >> ";
                        cin >> addedNum;
                        if (!useDupes)
                        {
                            validNum = true;
                            for (int val : list)
                            {
                                if (val == addedNum)
                                {
                                    cout << "\nInvalid number -- " << addedNum << " is already in the list and ";
                                    cout << "duplicates are not allowed.\nPlease try again";
                                    validNum = false;
                                }
                            }
                        }
                        else
                        {
                            validNum = true;
                        }
                    } while (!validNum);
                    list.push_back(addedNum);
                    sort(list.begin(), list.end());
                    cout << "\nAdded " << addedNum;
                    break;
                }
            case 'c':
            case 'C':
                {
                    list.clear();
                    cout << "\nList Cleared";
                    break;
                }
            case 'f':
            case 'F':
                {
                    int find {};
                    cout << "\nEnter the number you wish to find in the list: >> ";
                    cin >> find;
                    cout << "\nThe number '" << find << "' ";
                    if (useDupes)
                    {
                        int count {};
                        for (int val : list)
                        {
                            if (val == find)
                                count++;
                        }
                        cout << "is in the list " << count << " time";
                        if (count != 1)
                            cout << "s";
                    }
                    else
                    {
                        bool found {false};
                        for (int val : list)
                        {
                            if (val == find)
                                found = true;
                        }
                        cout << "is " << (found ? "" : "not") << " in the list";
                    }
                    break;
                }
            case 'l':
            case 'L':
                {
                    if (list.size() > 0)
                        cout << "\nThe largest number is " << list.back();
                    else
                        cout << "\nUnable to determine the largest number - list is empty";
                    break;
                }
            case 'm':
            case 'M':
                {
                    if (list.size() > 0)
                    {
                        double mean {};
                        int total {};
                        for (int val : list)
                            total += val;
                        mean = (double) total / list.size();
                        cout << "\nThe mean of the list is " << mean;
                    }
                    else
                        cout << "\nUnable to calculate the mean - no data";
                    break;
                }
            case 'p':
            case 'P':
                {
                    if (list.size() > 0)
                    {
                        cout << "\n[ ";
                        for (int val : list)
                            cout << val << " ";
                        cout << "]";
                    }
                    else
                        cout << "\n[] - the list is empty";
                    break;
                }
            case 's':
            case 'S':
                {
                    if (list.size() > 0)
                        cout << "\nThe smallest number is " << list.front();
                    else
                        cout << "\nUnable to determine the smallest number - list is empty";
                    break;
                }
            case 'q':
            case 'Q':
                {
                    cout << "\nGoodbye\n";
                    quit = true;
                    break;
                }
            case 'd':
            case 'D':
                if (list.size() == 0)
                {
                    useDupes = !useDupes;
                    if (useDupes)
                        cout << "\nNow allowing duplicate numbers in the list...";
                    else
                        cout << "\nNow disallowing duplicate numbers in the list...";
                    break;
                }
            default:
                cout << "\nUnknown selection, please try again";
                break;
        }
    };
    return 0;
}

int main(int argc, char *argv[])
{
    return 0;
}