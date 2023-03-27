/**
* @file TrustAccount.h
* @author Nicholas Walker
* @date 03/06/2023
*
* @brief Declares and creates the "TrustAccount" class
*/

#ifndef _TRUSTACCOUNT_H
#define _TRUSTACCOUNT_H

#include "SavingsAccount.h"

using namespace std;

// Trust Account is a type of Savings Account
//   which is also a type of Account
// Withdraw:
//      - only 3 withdraws allowed per year
//          + for sake of assignment, ignore yearly reset
//      - must be less than 20% account balance
// Deposit:
//      - Deposits of $5000 or more receive $50 bonus
//

class TrustAccount: public SavingsAccount {
    friend ostream &operator<<(ostream &os, const TrustAccount &account);
private:
    static constexpr const char *defName = "Unnamed Trust Account";
    static constexpr double defBalance = 0.0;
    static constexpr double defIntRate = 0.0;
    int withdrawCount {0};
protected:
    double intRate;
public:
    TrustAccount(string name = defName, double balance = defBalance, double intRate = defIntRate);    
    bool deposit(double amount);
    bool withdraw(double amount);
};

#endif // _TRUSTACCOUNT_H