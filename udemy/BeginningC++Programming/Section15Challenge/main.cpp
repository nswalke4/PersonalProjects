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
#include "AccountUtils.h"
#include "Account.h"
#include "CheckingAccount.h"
#include "SavingsAccount.h"
#include "TrustAccount.h"

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
    display(accounts);

    // Savings 
    vector<SavingsAccount> savAccounts;
    savAccounts.push_back(SavingsAccount {} );
    savAccounts.push_back(SavingsAccount {"Superman"} );
    savAccounts.push_back(SavingsAccount {"Batman", 2000} );
    savAccounts.push_back(SavingsAccount {"Wonderwoman", 5000, 5.0} );

    display(savAccounts);
    deposit(savAccounts, 1000);
    withdraw(savAccounts, 2000);
    display(savAccounts);
    /* End Provided Code*/

    cout << "End Provided Code -- testing new classes\n\n";

    
    // Checking
    cout << "\nBeginning Checking Accounts\n";

    vector<CheckingAccount> chAccounts;
    chAccounts.push_back(CheckingAccount {} );
    chAccounts.push_back(CheckingAccount {"Tucker"} );
    chAccounts.push_back(CheckingAccount {"Stella", 2000} );
    chAccounts.push_back(CheckingAccount {"Buck", 5000} );

    display(chAccounts);
    deposit(chAccounts, 1000);
    withdraw(chAccounts, 2000);
    display(chAccounts);

    // Trust
    cout << "\nBeginning Trust Accounts\n";

    vector<TrustAccount> trustAccounts;
    trustAccounts.push_back(TrustAccount {} );
    trustAccounts.push_back(TrustAccount {"Ranger"} );
    trustAccounts.push_back(TrustAccount {"Bower", 2000} );
    trustAccounts.push_back(TrustAccount {"Samson", 5000} );

    display(trustAccounts);
    deposit(trustAccounts, 1000);
    deposit(trustAccounts, 6000);
    withdraw(trustAccounts, 20000);
    withdraw(trustAccounts, 20);
    withdraw(trustAccounts, 20);
    withdraw(trustAccounts, 20);
    withdraw(trustAccounts, 20);
    display(trustAccounts);

    return 0;
}
