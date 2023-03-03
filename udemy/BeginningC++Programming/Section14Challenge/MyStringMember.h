/**
* @file MyStringMember.h
* @author Nicholas Walker
* @date 03/02/2023
*
* @brief Declares and creates the "MyStringMember" class
*/

#ifndef _MYSTRINGMEMBER_H_
#define _MYSTRINGMEMBER_H_

#include <iostream>

using namespace std;

class MyStringMember
{
    // Stream Insertion & Extraction Operator Overloads
    friend ostream &operator<<(ostream &, const MyStringMember &);
    friend istream &operator>>(istream &, MyStringMember &);

    // other friend variables/functions

private:
    // args
    

public:
    // Constructors / Destructor
    MyStringMember();                // Default Constructor
    MyStringMember(const MyStringMember &);    // Copy Constructor
    MyStringMember(MyStringMember &&);         // Move Constructor
    ~MyStringMember();               // Destructor

    // Operator Overloads
    MyStringMember &operator=(const MyStringMember &);    // Copy Assignment Operator Overload
    MyStringMember &operator=(MyStringMember &&);         // Move Assignment Operator Overload

    MyStringMember operator-() const;            // Negation Operator Overload
    MyStringMember operator++();                 // Pre-Increment Operator Overload
    MyStringMember operator++(int);              // Post-Increment Operator Overload
    MyStringMember operator--();                 // Pre-Decrement Operator Overload
    MyStringMember operator--(int);              // Post-Decrement Operator Overload
    bool operator!() const;             // Not Operator Overload

    MyStringMember operator+(const MyStringMember &) const;   // Addition Operator Overload
    MyStringMember operator-(const MyStringMember &) const;   // Subtraction Operator Overload
    bool operator==(const MyStringMember &) const;   // Equal-To Operator Overload
    bool operator!=(const MyStringMember &) const;   // Not-Equal-To Operator Overload
    bool operator>(const MyStringMember &) const;    // Greater-Than Operator Overload
    bool operator>=(const MyStringMember &) const;   // Greater-Than or Equal-To Operator Overload
    bool operator<(const MyStringMember &) const;    // Less-Than Operator Overload
    bool operator<=(const MyStringMember &) const;   // Less-Than or Equal-To Operator Overload

    // Getters

    // Setters

    // Other Methods

};

# endif // _MYSTRINGMEMBER_H_