/**
* @file MyStringMember.cpp
* @author Nicholas Walker
* @date 03/02/2023
*
* @brief Implements the "MyStringMember" class functions
*/

#include <iostream>
#include <cstring>
#include "MyStringMember.h"

using namespace std;

const bool DEBUG = true;

/********************************/
/* Constructors and Destructors */
/********************************/

// No-Args Constructor
MyStringMember::MyStringMember()
    : str {nullptr} {
        str = new char[1];
        *str = '\0';
        if (DEBUG)
            cout << "[DEBUG] No-arg constructor used" << endl;
}

// One-Arg Constructor
MyStringMember::MyStringMember(const char *s)
    : str {nullptr} {
        if (s == nullptr)
        {
            str = new char[1];
            *str = '\0';
        }
        else
        {
            str = new char[strlen(s) + 1];
            strcpy(str, s);
        }
        if (DEBUG)
            cout << "[DEBUG] One-arg constructor used" << endl;
}

// Copy Constructor
MyStringMember::MyStringMember(const MyStringMember &source)
    : str {nullptr} {
        str = new char[strlen(source.str) + 1];
        strcpy(str, source.str);
        if (DEBUG)
            cout << "[DEBUG] Copy constructor used" << endl;
}

// Move Constructor
MyStringMember::MyStringMember(MyStringMember &&source)
    : str(source.str) {
        source.str = nullptr;
        if (DEBUG)
            cout << "[DEBUG] Move constructor used" << endl;
}

// Destructor
MyStringMember::~MyStringMember()
{
    delete [] str;
    if (DEBUG)
        cout << "[DEBUG] Destructor used" << endl;
}

/***********/
/* Getters */
/***********/

// Return the string
const char *MyStringMember::get_str() const { return str; }

// Return the string length
int MyStringMember::get_length() const { return strlen(str); }

/*******************/
/* Other Functions */
/*******************/

// Display Function
void MyStringMember::display() const
{
    cout << str << ": " << get_length() << endl;
}

/***********************************************/
/* Insertion and Extraction Operator Overloads */
/***********************************************/

// Stream Insertion Overload
ostream &operator<<(ostream &out, const MyStringMember &rhs)
{
    out << rhs.str;
    return out;
} 

// Stream Extraction Overload
istream &operator>>(istream &in, MyStringMember &rhs)
{
    char *buff = new char[1000];
    in >> buff;
    rhs = MyStringMember{buff};
    delete [] buff;
    return in;
}

/******************************************/
/* Operator Assignment Overload Functions */
/******************************************/

// Copy Assignment Operator Overload
MyStringMember &MyStringMember::operator=(const MyStringMember &rhs)
{
    if (DEBUG)
        cout << "[DEBUG] Copy Assignment overload used" << endl;
    if (this != &rhs)
    {
        delete [] str;
        str = new char[strlen(rhs.str) + 1];
        strcpy(str, rhs.str);
    }
    return *this;
}

// Move Assignment Operator Overload
MyStringMember &MyStringMember::operator=(MyStringMember &&rhs)
{
    if (DEBUG)
        cout << "[DEBUG] Move Assignment overload used" << endl;
    if (this != &rhs)
    {
        delete [] str;
        str = rhs.str;
        rhs.str = nullptr;
    }
    return *this;
}

///////////////////////////////////////////////////////////////////////////////
/**************************************/
/* Member Operator Overload Functions */
/**************************************/

// Unary Minus Operator Overload
MyStringMember MyStringMember::operator-() const
{
    if (DEBUG)
        cout << "[DEBUG] Unary Minus overload used" << endl;
}

// Pre-Increment Operator Overload
MyStringMember MyStringMember::operator++()
{
    if (DEBUG)
        cout << "[DEBUG] Pre-Increment overload used" << endl;
}

// Post-Increment Operator Overload
MyStringMember MyStringMember::operator++(int val)
{
    if (DEBUG)
        cout << "[DEBUG] Post-Increment overload used" << endl;
}

// Equal-To Operator Overload
bool MyStringMember::operator==(const MyStringMember &other) const
{
    if (DEBUG)
        cout << "[DEBUG] Equal-To overload used" << endl;
    return false;
}

// Not-Equal-To Operator Overload
bool MyStringMember::operator!=(const MyStringMember &) const
{
    if (DEBUG)
        cout << "[DEBUG] Not-Equal-To overload used" << endl;
    return false;
}

// Less-Than Operator Overload
bool MyStringMember::operator<(const MyStringMember &other) const
{
    if (DEBUG)
        cout << "[DEBUG] Less-Than overload used" << endl;
    return false;
}

// Greater-Than Operator Overload
bool MyStringMember::operator>(const MyStringMember &other) const
{
    if (DEBUG)
        cout << "[DEBUG] Greater-Than overload used" << endl;
    return false;
}

// Addition Operator Overload
MyStringMember MyStringMember::operator+(const MyStringMember &other) const
{
    if (DEBUG)
        cout << "[DEBUG] Addition overload used" << endl;
}

// Increased-By Operator Overload
MyStringMember MyStringMember::operator+=(const MyStringMember &other) const
{
    if (DEBUG)
        cout << "[DEBUG] Increased-By overload used" << endl;
}

// Multiplication Operator Overload
MyStringMember MyStringMember::operator*(const MyStringMember &other) const
{
    if (DEBUG)
        cout << "[DEBUG] Multiplication overload used" << endl;
}

// Multiplied-By Operator Overload
MyStringMember MyStringMember::operator*=(const MyStringMember &other) const
{
    if (DEBUG)
        cout << "[DEBUG] Multiplied-By overload used" << endl;
}
