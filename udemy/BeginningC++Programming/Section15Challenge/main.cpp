/**
 * @file main.cpp
 * @author Nicholas Walker
 * @date 03/06/2023
 *
 * @brief The main functionality of the Accounts C++ program
*        **NOTE: A portion of this code was provided by the course instructor
 */

#include <iostream>
#include <vector>
#include "SavingsAccount.h"
#include "AccountUtils.h"

using namespace std;

int main(int argc, char *argv[])
{
    /* Begin Provided Code */
    cout.precision(2);
    cout << fixed;

    // Accounts
    vector<Account> accounts;
    accounts.push_back(Account {});
    accounts.push_back(Account {"Larry"});
    accounts.push_back(Account {"Moe", 2000} );
    accounts.push_back(Account {"Curly", 5000} );

    display(accounts);
    deposit(accounts, 1000);
    withdraw(accounts,2000);

    // Savings 
    vector<SavingsAccount> sav_accounts;
    sav_accounts.push_back(SavingsAccount {} );
    sav_accounts.push_back(SavingsAccount {"Superman"} );
    sav_accounts.push_back(SavingsAccount {"Batman", 2000} );
    sav_accounts.push_back(SavingsAccount {"Wonderwoman", 5000, 5.0} );

    display(sav_accounts);
    deposit(sav_accounts, 1000);
    withdraw(sav_accounts, 2000);
    /* End Provided Code*/

    return 0;
}
