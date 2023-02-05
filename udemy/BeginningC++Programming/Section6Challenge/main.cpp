/**
 * @file main.cpp
 * @author Nicholas Walker
 * @date 02/04/2022
 *
 * @brief Create a basic estimate program for Section 6's Challenge
 */

#include <iostream>

using namespace std;

int main(int argc, char *argv[])
{
    const double largeRoomPrice {35.0};
    const double smallRoomPrice {25.0};
    const double taxRate {0.06};
    const int estimateLength {30};
    int numLargeRooms {0};
    int numSmallRooms {0};
    double cost {0.0};
    double tax {0.0};
    double total {0.0};

    cout << "Welcome to Frank's Carpet Cleaning Service!!" << endl;
    cout << "\nPlease enter the number of small rooms to be cleaned: ";
    cin >> numSmallRooms;
    cout << "Please enter the number of large rooms to be cleaned: ";
    cin >> numLargeRooms;

    cost = (numSmallRooms * smallRoomPrice) + (numLargeRooms * largeRoomPrice);
    tax = cost * taxRate;
    total = cost + tax;

    cout << "\n\nEstimate for carpet cleaning service:\nNumber of small rooms: "
         << numSmallRooms << "\nNumber of large rooms: " << numLargeRooms
         << "\nPrice per small room: $" << smallRoomPrice << "\nPrice per large room: $"
         << largeRoomPrice << "\nCost: $" << cost << "\nTax: $" << tax
         << "\n===========================================\nTotal estimate: $"
         << total << "\nThis estimate is valid for " << estimateLength << " days" << endl;

    return 0;
}
