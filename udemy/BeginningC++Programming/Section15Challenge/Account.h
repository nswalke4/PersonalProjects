/**
* @file Account.h
* @author Nicholas Walker
* @date 03/06/2023
*
* @brief Declares and creates the "Account" class
*        **NOTE: This code was provided by the course instructor
*/

#ifndef _ACCOUNT_H_
#define _ACCOUNT_H_
#include <iostream>
#include <string>

class Account {
    friend std::ostream &operator<<(std::ostream &os, const Account &account);
private:   
    static constexpr const char *defName = "Unnamed Account";
    static constexpr double defBalance = 0.0;
protected:
    std::string name;
    double balance;
public:
    Account(std::string name = defName, double balance = defBalance);
    // Account(std::string name = "Unamed Account", double balance = 0.0);
    bool deposit(double amount);
    bool withdraw(double amount);
    double get_balance() const;
};

#endif // _ACCOUNT_HS