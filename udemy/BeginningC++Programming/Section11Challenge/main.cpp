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

void addNumber(vector<int> &, const bool);
void clearList(vector<int> &);
void findNumber(const vector<int> &, const bool);
char getLetter();
int getNumToAddToList(const vector<int> &, const bool);
int getNumToFindInList();
void printList(const vector<int> &);
void quitProgram(bool &);
void runProgram();
void showMainMenu(const size_t, const bool);
void showMean(const vector<int> &);
void showEndValue(const vector<int> &, const bool);
void swapAllowDupes(bool &);

int main(int argc, char *argv[])
{
    runProgram();
    return 0;
}

void addNumber(vector<int> &list, const bool useDupes)
{
    int addedNum {getNumToAddToList(list, useDupes)};
    list.push_back(addedNum);
    sort(list.begin(), list.end());
    cout << "\nAdded " << addedNum;
}

void clearList(vector<int> &list)
{
    list.clear();
    cout << "\nList Cleared";
}

void findNumber(const vector<int> &list, const bool useDupes)
{
    int find {getNumToFindInList()};
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
}

char getLetter()
{
    char menuSelection {};
    cout << "\nEnter your choice >> ";
    cin >> menuSelection;
    return menuSelection;
}

int getNumToAddToList(const vector<int> &list, const bool useDupes)
{
    bool validNum {true};
    int addedNum {};
    do
    {
        cout << "\nEnter the number you wish to add to the list >> ";
        cin >> addedNum;
        if (!useDupes)
        {
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
    } while (!validNum);
    return addedNum;
}

int getNumToFindInList()
{
    int find {};
    cout << "\nEnter the number you wish to find in the list: >> ";
    cin >> find;
    return find;
}

void printList(const vector<int> &list)
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
}

void quitProgram(bool &quit)
{
    cout << "\nGoodbye\n";
    quit = true;
}

void runProgram()
{
    bool quit {false};
    bool useDupes {false};
    vector<int> list {};

    cout << boolalpha;
    while (!quit) {
        showMainMenu(list.size(), useDupes);
        switch (getLetter()) {
            case 'a':
            case 'A':
                addNumber(list, useDupes);
                break;
            case 'c':
            case 'C':
                clearList(list);
                break;
            case 'f':
            case 'F':
                findNumber(list, useDupes);
                break;
            case 'l':
            case 'L':
                showEndValue(list, false);
                break;
            case 'm':
            case 'M':
                showMean(list);
                break;
            case 'p':
            case 'P':
                printList(list);
                break;
            case 's':
            case 'S':
                showEndValue(list, true);
                break;
            case 'q':
            case 'Q':
                quitProgram(quit);
                break;
            case 'd':
            case 'D':
                if (list.size() == 0)
                {
                    swapAllowDupes(useDupes);
                    break;
                }
            default:
                cout << "\nUnknown selection, please try again";
                break;
        }
    };
}

void showMainMenu(const size_t listSize, const bool useDupes)
{
    cout << "\n\n+---------+\n|Main Menu|\n+---------+";
    if (listSize == 0)
        cout << "\nD - Allow Duplicate Numbers? Currently " << useDupes;
    cout << "\nP - Print numbers\nA - Add a number\nF - Find a number\n";
    cout << "M - Display mean of the numbers\nS - Display the smallest number\n";
    cout << "L - Display the largest number\nC - Clear the List\nQ - Quit\n";
}

void showMean(const vector<int> &list)
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
}

void showEndValue(const vector<int> &list, const bool smallest)
{
    string end {smallest ? "smallest" : "largest"};
    int val {smallest ? list.front() : list.back()};
    if (list.size() > 0)
        cout << "\nThe " << end << " number is " << val;
    else
        cout << "\nUnable to determine the " << end << " number - list is empty";
}

void swapAllowDupes(bool &useDupes)
{
    useDupes = !useDupes;
    if (useDupes)
        cout << "\nNow allowing duplicate numbers in the list...";
    else
        cout << "\nNow disallowing duplicate numbers in the list...";
}
