/**
* @file MyStringNonMember.h
* @author Nicholas Walker
* @date 03/02/2023
*
* @brief Declares and creates the "MyStringNonMember" class
*/

#ifndef _MYSTRINGNONMEMBER_H_
#define _MYSTRINGNONMEMBER_H_

#include <iostream>

using namespace std;

class MyStringNonMember
{
    // Stream Insertion & Extraction Operator Overloads
    friend ostream &operator<<(ostream &, const MyStringNonMember &);
    friend istream &operator>>(istream &, MyStringNonMember &);

    // other friend variables/functions

private:
    // args
    

public:
    // Constructors / Destructor
    MyStringNonMember();                // Default Constructor
    MyStringNonMember(const MyStringNonMember &);    // Copy Constructor
    MyStringNonMember(MyStringNonMember &&);         // Move Constructor
    ~MyStringNonMember();               // Destructor

    // Operator Overloads
    MyStringNonMember &operator=(const MyStringNonMember &);    // Copy Assignment Operator Overload
    MyStringNonMember &operator=(MyStringNonMember &&);         // Move Assignment Operator Overload

    MyStringNonMember operator-() const;            // Negation Operator Overload
    MyStringNonMember operator++();                 // Pre-Increment Operator Overload
    MyStringNonMember operator++(int);              // Post-Increment Operator Overload
    MyStringNonMember operator--();                 // Pre-Decrement Operator Overload
    MyStringNonMember operator--(int);              // Post-Decrement Operator Overload
    bool operator!() const;             // Not Operator Overload

    MyStringNonMember operator+(const MyStringNonMember &) const;   // Addition Operator Overload
    MyStringNonMember operator-(const MyStringNonMember &) const;   // Subtraction Operator Overload
    bool operator==(const MyStringNonMember &) const;   // Equal-To Operator Overload
    bool operator!=(const MyStringNonMember &) const;   // Not-Equal-To Operator Overload
    bool operator>(const MyStringNonMember &) const;    // Greater-Than Operator Overload
    bool operator>=(const MyStringNonMember &) const;   // Greater-Than or Equal-To Operator Overload
    bool operator<(const MyStringNonMember &) const;    // Less-Than Operator Overload
    bool operator<=(const MyStringNonMember &) const;   // Less-Than or Equal-To Operator Overload

    // Getters

    // Setters

    // Other Methods

};

# endif // _MYSTRINGNONMEMBER_H_