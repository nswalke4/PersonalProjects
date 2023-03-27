/**
* @file SavingsAccount.h
* @author Nicholas Walker
* @date 03/06/2023
*
* @brief Declares and creates the "SavingsAccount" class
*        **NOTE: This code was provided by the course instructor
*/

#ifndef _SAVINGSACCOUNT_H
#define _SAVINGSACCOUNT_H

#include "Account.h"

// Savings Account is a type of Account
//   adds an interest rate
// Withdraw - same as a regular account
// Deposit:
//      Amount supplied to deposit will be incremented by (amount * int_rate/100) 
//      and then the updated amount will be deposited
//

class SavingsAccount: public Account {
    friend std::ostream &operator<<(std::ostream &os, const SavingsAccount &account);
private:
    static constexpr const char *defName = "Unnamed Savings Account";
    static constexpr double defBalance = 0.0;
    static constexpr double defIntRate = 0.0;
protected:
    double intRate;
public:
    SavingsAccount(std::string name = defName, double balance = defBalance, double intRate = defIntRate);    
    bool deposit(double amount);
    // Inherits the Account::withdraw methods
};

#endif // _SAVINGSACCOUNT_H