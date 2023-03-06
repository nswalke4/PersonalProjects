/**
* @file AccountUtils.h
* @author Nicholas Walker
* @date 03/06/2023
*
* @brief Declares and creates the "AccountUtils" class
*        **NOTE: This code was provided by the course instructor
*/

#ifndef _ACCOUNTUTILS_H
#define _ACCOUNTUTILS_H

#include <vector>
#include "Account.h"
#include "SavingsAccount.h"

// Utility helper functions for Account class

void display(const std::vector<Account> &accounts);
void deposit(std::vector<Account> &accounts, double amount);
void withdraw(std::vector<Account> &accounts, double amount);

// Utility helper functions for Savings Account class

void display(const std::vector<SavingsAccount> &accounts);
void deposit(std::vector<SavingsAccount> &accounts, double amount);
void withdraw(std::vector<SavingsAccount> &accounts, double amount);

#endif // _ACCOUNTUTILS_H