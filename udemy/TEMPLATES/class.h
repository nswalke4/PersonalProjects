/**
 * @file <class.h>
 * @author Nicholas Walker
 * @date xx/xx/xxxx
 *
 * @brief Declares and creates the "<class>" class
 */

#ifndef _CLASS_H_
#define _CLASS_H_

#include <iostream>

using namespace std;

class Class
{
    // friend functions

private:
    // args

public:
    // Constructors / Destructor
    Class();                // Default Constructor
    Class(const Class &);   // Copy Constructor
    Class(Class &&);        // Move Constructor
    ~Class();               // Destructor

    // Operator Overloads
    Class &operator=(const Class &);    // Copy Assignment Operator Overload
    Class &operator=(Class &&);         // Move Assignment Operator Overload

    Class operator-() const;            // Negation Operator Overload
    Class operator++();                 // Pre-Increment Operator Overload
    Class operator++(int);              // Post-Increment Operator Overload
    Class operator--();                 // Pre-Decrement Operator Overload
    Class operator--(int);              // Post-Decrement Operator Overload
    bool operator!() const;             // Not Operator Overload

    Class operator+(const Class &) const;   // Addition Operator Overload
    Class operator-(const Class &) const;   // Subtraction Operator Overload
    bool operator==(const Class &) const;   // Equal-To Operator Overload
    bool operator!=(const Class &) const;   // Not-Equal-To Operator Overload
    bool operator>(const Class &) const;    // Greater-Than Operator Overload
    bool operator>=(const Class &) const;   // Greater-Than or Equal-To Operator Overload
    bool operator<(const Class &) const;    // Less-Than Operator Overload
    bool operator<=(const Class &) const;   // Less-Than or Equal-To Operator Overload

    // Getters

    // Setters

    // Other Methods

};

# endif // _CLASS_H_