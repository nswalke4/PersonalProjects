# Add Checking and Trust Accounts that Inherit from Account

<table>
<tr>
<th>Time to Complete</th>
<td>tbd</td>
</tr>
<tr>
<th>Date Completed</th>
<td>03/06/2023</td>
</tr>
</table>

<hr />

## Directions

Modify the "Accounts" C++ Program to include a "Checking" and "Trust" account.  These accounts should inherit the base "Account" class.  In particular:
1. Add a Checking account class to the Account hierarchy
    - A Checking account has a name and a balance and has a fee of $1.50 per withdrawal transaction.
    - Every withdrawal transaction will be assessed this flat fee.
2. Add a Trust account class to the Account hierarchy
    - A Trust account has a name, a balance, and an interest rate
    - The Trust account deposit works just like a savings account deposit.
    - However, any deposits of $5000.00 or more will receive a $50.00 bonus deposited to the account.
    - The Trust account withdrawal should only allow 3 withdrawals per year and each of these must be less than 20% of the account balance.
    - You don't have to keep track of calendar time for this application, just make sure the 4th withdrawal fails
    - 
_For additional practice with operator overloading, I am overloading += and -= for deposit and withdrawal_


### Provided Files

The course instructor provided a simple Account class hierarchy that contains
- Account - Base class
- Savings Account - Derived class

An Account has a name and a balance. A Savings Account is an Account and adds an interest rate.  I have also provided some Account helper functions in Account_Util.h and Account_Util.cpp that make it easy to display, deposit to, and withdraw from a vector of Accounts and Savings Accounts.  Please refer to the source code provided and the video explanation of this challenge for more details.


### Hints:
- Reuse existing functionality!!
- Think about what the Base class will be for the new classes.
- Add helper functions to Account_Util.h and Account_Util.cpp if you wish to work with your new classes.
  - (You don't have to, but it will make your main much easier to use)


