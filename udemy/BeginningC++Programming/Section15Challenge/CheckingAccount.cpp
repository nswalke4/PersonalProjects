/**
* @file CheckingAccount.cpp
* @author Nicholas Walker
* @date 03/06/2023
*
* @brief Implements the "CheckingAccount" class functions
*/

#include <iostream>
#include "CheckingAccount.h"

using namespace std;

CheckingAccount::CheckingAccount(std::string name, double balance)
    : Account {name, balance} {
}

// Withdraw:
//      Amount supplied to withdraw will include a $1.50 fee and must
//      ensure the funds are available
//
bool CheckingAccount::withdraw(double amount) {
    amount += 1.50;
    return Account::withdraw(amount);
}

std::ostream &operator<<(std::ostream &os, const CheckingAccount &account) {
    os << "[CheckingAccount: " << account.name << ": " << account.balance << "]";
    return os;
}

