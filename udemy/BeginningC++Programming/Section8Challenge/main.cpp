/**
 * @file main.cpp
 * @author Nicholas Walker
 * @date 02/05/2023
 *
 * @brief Displays to the user how to create change for the amount entered
 */

#include <iostream>

using namespace std;

int main(int argc, char *argv[])
{
    const int DOLLAR {100};
    const int QUARTER {25};
    const int DIME {10};
    const int NICKLE {5};
    const int PENNY {1};
    int amount {}, remaining {}, numDollar {}, numQuarter {}, numDime {}, numNickle {}, numPenny {};

    cout << "Enter an amount in cents:  ";
    cin >> amount;
    
    remaining = amount;
    // NOTE: Did not notice the directions mentioning to do this using the modulo operator
    // until after I had completed the work.  I commented out the while loops and reimplemented
    // utilizing that operator, and found this was much more efficient than my original solution.

    numDollar = remaining / DOLLAR;
    remaining %= DOLLAR;
    // while (remaining >= DOLLAR) {
    //     remaining -= DOLLAR;
    //     numDollar++;
    // }
    numQuarter = remaining / QUARTER;
    remaining %= QUARTER;
    // while (remaining >= QUARTER) {92
    //     remaining -= QUARTER;
    //     numQuarter++;
    // }
    numDime = remaining / DIME;
    remaining %= DIME;
    // while (remaining >= DIME) {
    //     remaining -= DIME;
    //     numDime++;
    // }
    numNickle = remaining / NICKLE;
    remaining %= NICKLE;
    // while (remaining >= NICKLE) {
    //     remaining -= NICKLE;
    //     numNickle++;
    // }
    numPenny = remaining / PENNY;
    remaining %= PENNY;
    // while (remaining >= PENNY) {
    //     remaining -= PENNY;
    //     numPenny++;
    // }

    cout << "\n\nThe change for " << amount << " cents is provided using the following:"
         << "\n\t dollars: " << numDollar << "\n\tquarters: " << numQuarter
         << "\n\t   dimes: " << numDime << "\n\t nickels: " << numNickle
         << "\n\t pennies: " << numPenny << endl;
    return 0;
}
