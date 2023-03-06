/**
 * @file class.h--TEMPLATE
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
    // Stream Insertion & Extraction Operator Overloads
    friend ostream &operator<<(ostream &, const Class &);
    friend istream &operator>>(istream &, Class &);

    // Operator Overloads as "Non-Member" Functions
    friend Class operator+(const Class &);          // Positive Operator Overload
    friend Class operator-(const Class &);          // Negation Operator Overload
    friend Class operator++(const Class &);         // Pre-Increment Operator Overload
    friend Class operator++(const Class &, int);    // Post-Increment Operator Overload
    friend Class operator--(const Class &);         // Pre-Decrement Operator Overload
    friend Class operator--(const Class &, int);    // Post-Decrement Operator Overload
    friend bool operator!(const Class &);           // Not Operator Overload

    friend Class operator+(const Class &, const Class &);   // Addition Operator Overload
    friend Class operator+=(const Class &, const Class &);  // Increased-By Operator Overload
    friend Class operator-(const Class &, const Class &);   // Subtraction Operator Overload
    friend Class operator-=(const Class &, const Class &);  // Decreased-By Operator Overload
    friend Class operator*(const Class &, const Class &);   // Multiplication Operator Overload
    friend Class operator*=(const Class &, const Class &);  // Multiplied-By Operator Overload
    friend Class operator/(const Class &, const Class &);   // Division Operator Overload
    friend Class operator/=(const Class &, const Class &);  // Divided-By Operator Overload
    friend Class operator%(const Class &, const Class &);   // Modulo Operator Overload
    friend Class operator%=(const Class &, const Class &);  // Modulous-Of Operator Overload
    friend bool operator==(const Class &, const Class &);   // Equal-To Operator Overload
    friend bool operator!=(const Class &, const Class &);   // Not-Equal-To Operator Overload
    friend bool operator>(const Class &, const Class &);    // Greater-Than Operator Overload
    friend bool operator>=(const Class &, const Class &);   // Greater-Than or Equal-To Operator Overload
    friend bool operator<(const Class &, const Class &);    // Less-Than Operator Overload
    friend bool operator<=(const Class &, const Class &);   // Less-Than or Equal-To Operator Overload

    // other friend variables/functions

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

    Class operator+() const;            // Positive Operator Overload
    Class operator-() const;            // Negation Operator Overload
    Class operator++();                 // Pre-Increment Operator Overload
    Class operator++(int);              // Post-Increment Operator Overload
    Class operator--();                 // Pre-Decrement Operator Overload
    Class operator--(int);              // Post-Decrement Operator Overload
    bool operator!() const;             // Not Operator Overload

    Class operator+(const Class &) const;   // Addition Operator Overload
    Class operator+=(const Class &) const;  // Increased-By Operator Overload
    Class operator-(const Class &) const;   // Subtraction Operator Overload
    Class operator-=(const Class &) const;  // Decreased-By Operator Overload
    Class operator*(const Class &) const;   // Multiplication Operator Overload
    Class operator*=(const Class &) const;  // Multiplied-By Operator Overload
    Class operator/(const Class &) const;   // Division Operator Overload
    Class operator/=(const Class &) const;  // Divided-By Operator Overload
    Class operator%(const Class &) const;   // Modulo Operator Overload
    Class operator%=(const Class &) const;  // Modulous-Of Operator Overload
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