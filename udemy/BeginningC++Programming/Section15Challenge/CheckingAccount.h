/**
* @file CheckingAccount.h
* @author Nicholas Walker
* @date 03/06/2023
*
* @brief Declares and creates the "CheckingAccount" class
*/

#ifndef _CHECKINGACCOUNT_H
#define _CHECKINGACCOUNT_H

#include "Account.h"

using namespace std;

// Checking Account is a type of Account
//   that charges each time a withdrawal is made
// Withdraw - has a $1.50 withdrawal fee each transaction
// Deposit - same as regular account
//

class CheckingAccount: public Account {
    friend ostream &operator<<(ostream &os, const CheckingAccount &account);
private:
    static constexpr const char *defName = "Unnamed Checking Account";
    static constexpr double defBalance = 0.0;
public:
    CheckingAccount(string name = defName, double balance = defBalance);    
    bool withdraw(double amount);
    // Inherits the Acccount::deposit method
};



#endif // _CHECKINGACCOUNT_H