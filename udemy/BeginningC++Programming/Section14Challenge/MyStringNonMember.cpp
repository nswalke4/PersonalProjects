/**
* @file MyStringNonMember.h
* @author Nicholas Walker
* @date 03/02/2023
*
* @brief Implements the "MyStringNonMember" class functions
*/

#include <iostream>
#include <cstring>
#include "MyStringNonMember.h"

using namespace std;

// const bool DEBUG = true;
const bool DEBUG = false;

/********************************/
/* Constructors and Destructors */
/********************************/

// No-Args Constructor
MyStringNonMember::MyStringNonMember()
    : str {nullptr} {
        str = new char[1];
        *str = '\0';
        if (DEBUG)
            cout << "[DEBUG] No-arg constructor used" << endl;
}

// One-Arg Constructor
MyStringNonMember::MyStringNonMember(const char *s)
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
MyStringNonMember::MyStringNonMember(const MyStringNonMember &source)
    : str {nullptr} {
        str = new char[strlen(source.str) + 1];
        strcpy(str, source.str);
        if (DEBUG)
            cout << "[DEBUG] Copy constructor used" << endl;
}

// Move Constructor
MyStringNonMember::MyStringNonMember(MyStringNonMember &&source)
    : str(source.str) {
        source.str = nullptr;
        if (DEBUG)
            cout << "[DEBUG] Move constructor used" << endl;
}

// Destructor
MyStringNonMember::~MyStringNonMember()
{
    delete [] str;
    if (DEBUG)
        cout << "[DEBUG] Destructor used" << endl;
}

/***********/
/* Getters */
/***********/

// Return the string
const char *MyStringNonMember::get_str() const { return str; }

// Return the string length
int MyStringNonMember::get_length() const { return strlen(str); }

/*******************/
/* Other Functions */
/*******************/

// Display Function
void MyStringNonMember::display() const
{
    cout << str << ": " << get_length() << endl;
}

/***********************************************/
/* Insertion and Extraction Operator Overloads */
/***********************************************/

// Stream Insertion Overload
ostream &operator<<(ostream &out, const MyStringNonMember &rhs)
{
    out << rhs.str;
    return out;
} 

// Stream Extraction Overload
istream &operator>>(istream &in, MyStringNonMember &rhs)
{
    char *buff = new char[1000];
    in >> buff;
    rhs = MyStringNonMember{buff};
    delete [] buff;
    return in;
}

/******************************************/
/* Operator Assignment Overload Functions */
/******************************************/

// Copy Assignment Operator Overload
MyStringNonMember &MyStringNonMember::operator=(const MyStringNonMember &rhs)
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
MyStringNonMember &MyStringNonMember::operator=(MyStringNonMember &&rhs)
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
/******************************************/
/* Non-Member Operator Overload Functions */
/******************************************/

// Unary Minus Operator Overload
// Returns the lowercase version of the object's string
MyStringNonMember operator-(const MyStringNonMember &source)
{
    if (DEBUG)
        cout << "[DEBUG] Unary Minus overload used" << endl;
    char *buff = new char[strlen(source.str) + 1];
    strcpy(buff, source.str);
    for (size_t i = 0; i < strlen(buff); i++)
        buff[i] = tolower(buff[i]);
    MyStringNonMember temp {buff};
    delete [] buff;
    return temp;
}

// Pre-Increment Operator Overload
// Make all characters uppercase
MyStringNonMember operator++(const MyStringNonMember &source)
{
    if (DEBUG)
        cout << "[DEBUG] Pre-Increment overload used" << endl;
    for (size_t i = 0; i < strlen(source.str); i++)
        source.str[i] = toupper(source.str[i]);
    return source;
}

// Post-Increment Operator Overload
// Make all characters uppercase after use
MyStringNonMember operator++(const MyStringNonMember &source, int val)
{
    if (DEBUG)
        cout << "[DEBUG] Post-Increment overload used" << endl;
    MyStringNonMember temp {source};    // make a copy
    ++source;                           // call pre-increment - make sure you call pre-increment!
    return temp;                        // return the old value
}

// Equal-To Operator Overload
// returns true if the two strings are equal
bool operator==(const MyStringNonMember &lhs, const MyStringNonMember &rhs)
{
    if (DEBUG)
        cout << "[DEBUG] Equal-To overload used" << endl;
    return (strcmp(lhs.str, rhs.str) == 0);
}

// Not-Equal-To Operator Overload
// returns true if the two strings are not equal
bool operator!=(const MyStringNonMember &lhs, const MyStringNonMember &rhs)
{
    if (DEBUG)
        cout << "[DEBUG] Not-Equal-To overload used" << endl;
    return (strcmp(lhs.str, rhs.str) != 0);
}

// Less-Than Operator Overload
// returns true if the lhs string is lexically less than the rhs string
bool operator<(const MyStringNonMember &lhs, const MyStringNonMember &rhs)
{
    if (DEBUG)
        cout << "[DEBUG] Less-Than overload used" << endl;
    return (strcmp(lhs.str, rhs.str) < 0);
}

// Greater-Than Operator Overload
// returns true if the lhs string is lexically greater than the rhs string
bool operator>(const MyStringNonMember &lhs, const MyStringNonMember &rhs)
{
    if (DEBUG)
        cout << "[DEBUG] Greater-Than overload used" << endl;
    return (strcmp(lhs.str, rhs.str) > 0);
}

// Addition Operator Overload
// concatenation. Returns an object that concatenates the lhs and rhs
MyStringNonMember operator+(const MyStringNonMember &lhs, const MyStringNonMember &rhs)
{
    if (DEBUG)
        cout << "[DEBUG] Addition overload used" << endl;
    char *buff = new char[strlen(lhs.str) + strlen(rhs.str) + 1];
    strcpy(buff, lhs.str);
    strcat(buff, rhs.str);
    MyStringNonMember temp {buff};
    delete [] buff;
    return temp;
}

// Increased-By Operator Overload
// concatenate the rhs string to the lhs string and store the result in lhs object
MyStringNonMember &operator+=(MyStringNonMember &lhs, const MyStringNonMember &rhs)
{
    if (DEBUG)
        cout << "[DEBUG] Increased-By overload used" << endl;
    lhs = lhs + rhs;
    return lhs;
}

// Multiplication Operator Overload
// repeat -  results in a string that is copied n times
MyStringNonMember operator*(const MyStringNonMember &source, const int val)
{
    if (DEBUG)
        cout << "[DEBUG] Multiplication overload used" << endl;
    char *buff = new char[(strlen(source.str) * val) + 1];
    strcpy(buff, source.str);
    for (int i = 1; i < val; i++)
        strcat(buff, source.str);
    MyStringNonMember temp {buff};
    delete [] buff;
    return temp;
}

// Multiplied-By Operator Overload
// repeat the string on the lhs n times and store the result back in the lhs object
MyStringNonMember &operator*=(MyStringNonMember &source, const int val)
{
    if (DEBUG)
        cout << "[DEBUG] Multiplied-By overload used" << endl;
    source = source * val;
    return source;
}
