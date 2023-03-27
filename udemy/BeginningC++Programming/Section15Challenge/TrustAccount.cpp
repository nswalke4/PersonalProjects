/**
* @file TrustAccount.cpp
* @author Nicholas Walker
* @date 03/06/2023
*
* @brief Implements the "TrustAccount" class functions
*/

#include <iostream>
#include "TrustAccount.h"

using namespace std;

TrustAccount::TrustAccount(std::string name, double balance, double intRate)
    : SavingsAccount {name, balance}, intRate{intRate} {
}

// Deposit:
//      - Deposits of $5000 or more receive $50 bonus
//
bool TrustAccount::deposit(double amount) {
    if (amount >= 5000)
        amount += 50;
    return SavingsAccount::deposit(amount);
}

// Withdraw:
//      - only 3 withdraws allowed per year
//          + for sake of assignment, ignore yearly reset
//      - must be less than 20% account balance
//
bool TrustAccount::withdraw(double amount) {
    double percentBalance = this->balance * 0.2;
    cout << "Percent Balance = " << percentBalance << "; amount to withdraw = " << amount << endl;
    if (amount < (this->balance * 0.2)) {
        if (this->withdrawCount++ < 3)
            return SavingsAccount::withdraw(amount);
        else
            return false;
    } else {
        return false;
    }
}

std::ostream &operator<<(std::ostream &os, const TrustAccount &account) {
    os << "[TrustAccount: " << account.name << ": " << account.balance << ", " << account.intRate << "%]";
    return os;
}
