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

// const bool DEBUG = true;
const bool DEBUG = false;

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
// Returns the lowercase version of the object's string
MyStringMember MyStringMember::operator-() const
{
    if (DEBUG)
        cout << "[DEBUG] Unary Minus overload used" << endl;
    char *buff = new char[strlen(this->str) + 1];
    strcpy(buff, this->str);
    for (size_t i = 0; i < strlen(buff); i++)
        buff[i] = tolower(buff[i]);
    MyStringMember temp {buff};
    delete [] buff;
    return temp;
}

// Pre-Increment Operator Overload
// Make all characters uppercase
MyStringMember &MyStringMember::operator++()
{
    if (DEBUG)
        cout << "[DEBUG] Pre-Increment overload used" << endl;
    char *buff = new char[strlen(this->str) + 1];
    strcpy(buff, this->str);
    for (size_t i = 0; i < strlen(buff); i++)
        buff[i] = toupper(buff[i]);
    *this = MyStringMember(buff);
    return *this;
}

// Post-Increment Operator Overload
// Make all characters uppercase after use
MyStringMember MyStringMember::operator++(int val)
{
    if (DEBUG)
        cout << "[DEBUG] Post-Increment overload used" << endl;
    MyStringMember temp (*this);    // make a copy
    operator++();                   // call pre-increment - make sure you call pre-increment!
    return temp;                    // return the old value
}

// Equal-To Operator Overload
// returns true if the two strings are equal
bool MyStringMember::operator==(const MyStringMember &other) const
{
    if (DEBUG)
        cout << "[DEBUG] Equal-To overload used" << endl;
    return (strcmp(this->str, other.str) == 0);
}

// Not-Equal-To Operator Overload
// returns true if the two strings are not equal
bool MyStringMember::operator!=(const MyStringMember &other) const
{
    if (DEBUG)
        cout << "[DEBUG] Not-Equal-To overload used" << endl;
    return (strcmp(this->str, other.str) != 0);
}

// Less-Than Operator Overload
// returns true if the lhs string is lexically less than the rhs string
bool MyStringMember::operator<(const MyStringMember &other) const
{
    if (DEBUG)
        cout << "[DEBUG] Less-Than overload used" << endl;
    return (strcmp(this->str, other.str) < 0);
}

// Greater-Than Operator Overload
// returns true if the lhs string is lexically greater than the rhs string
bool MyStringMember::operator>(const MyStringMember &other) const
{
    if (DEBUG)
        cout << "[DEBUG] Greater-Than overload used" << endl;
    return (strcmp(this->str, other.str) > 0);
}

// Addition Operator Overload
// concatenation. Returns an object that concatenates the lhs and rhs
MyStringMember MyStringMember::operator+(const MyStringMember &other) const
{
    if (DEBUG)
        cout << "[DEBUG] Addition overload used" << endl;
    char *buff = new char[strlen(this->str) + strlen(other.str) + 1];
    strcpy(buff, this->str);
    strcat(buff, other.str);
    MyStringMember temp {buff};
    delete [] buff;
    return temp;
}

// Increased-By Operator Overload
// concatenate the rhs string to the lhs string and store the result in lhs object
MyStringMember &MyStringMember::operator+=(const MyStringMember &other)
{
    if (DEBUG)
        cout << "[DEBUG] Increased-By overload used" << endl;
    *this = *this + other;
    return *this;
}

// Multiplication Operator Overload
// repeat -  results in a string that is copied n times
MyStringMember MyStringMember::operator*(const int value) const
{
    if (DEBUG)
        cout << "[DEBUG] Multiplication overload used" << endl;
    char *buff = new char[(strlen(this->str)*value) + 1];
    strcpy(buff, this->str);
    for (int i = 1; i < value; i++)
        strcat(buff, this->str);
    MyStringMember temp {buff};
    delete [] buff;
    return temp;
}

// Multiplied-By Operator Overload
// repeat the string on the lhs n times and store the result back in the lhs object
MyStringMember &MyStringMember::operator*=(const int value)
{
    if (DEBUG)
        cout << "[DEBUG] Multiplied-By overload used" << endl;
    *this = *this * value;
    return *this;
}
