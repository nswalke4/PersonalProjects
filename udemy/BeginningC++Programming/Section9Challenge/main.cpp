/**
 * @file Main.cpp
 * @author Nicholas Walker
 * @date 02/27/2023
 *
 * @brief Run menu-based program to allow user to manipulate a list of integers
 */

#include <iostream>
#include <iomanip>
#include <algorithm>
#include <vector>

using namespace std;

int main(int argc, char *argv[])
{
    bool quit {false};
    bool useDupes {false};
    char menuSelection {};
    vector<int> list {};

    string mostChoices {};

    cout << boolalpha;
    while (!quit) {
        bool validNum {false};
        int addedNum {};
        cout << "\n\n+---------+\n|Main Menu|\n+---------+";
        if (list.size() == 0);
            cout << "\nD - Allow Duplicate Numbers? Currently " << useDupes;
        cout << "\nP - Print numbers\nA - Add a number\nF - Find a number\n";
        cout << "M - Display mean of the numbers\nS - Display the smallest number\n";
        cout << "L - Display the largest number\nC - Clear the List\nQ - Quit\n";
        cout << "\nEnter your choice >> ";
        cin >> menuSelection;
        switch (menuSelection) {
            case 'a':
            case 'A':
                do
                {
                    cout << "\nEnter the number you wish to add to the list >>";
                    cin >> addedNum;
                    if (useDupes) {
                        for (int i = 0; i < list.size(); i++) {
                            if (list.at(i) == addedNum) {
                                cout << "\nInvalid number -- " << addedNum << " is already in the list and ";
                                cout << "duplicates are not allowed.\nPlease try again";
                            }
                        }
                        validNum = true;
                    } else {
                        validNum = true;
                    }
                } while (!validNum);
                list.push_back(addedNum);
                sort(list.begin(), list.end());
                cout << "\nAdded " << addedNum;
                break;
            case 'c':
            case 'C':
                list.clear();
                cout << "\nList Cleared";
                break;
            case 'f':
            case 'F':
                cout << "\nFind a number";
                break;
            case 'l':
            case 'L':
                cout << "\nFind the largest";
                break;
            case 'm':
            case 'M':
                cout << "\nFind the mean";
                break;
            case 'p':
            case 'P':
                cout << "\nPrint the numbers";
                break;
            case 's':
            case 'S':
                cout << "\nFind the smallest";
                break;
            case 'q':
            case 'Q':
                cout << "\nGoodbye\n";
                quit = true;
                break;
            case 'd':
            case 'D':
                if (list.size() == 0) {
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
