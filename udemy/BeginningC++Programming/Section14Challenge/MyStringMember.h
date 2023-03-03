/**
* @file MyStringMember.h
* @author Nicholas Walker
* @date 03/02/2023
*
* @brief Declares and creates the "MyStringMember" class
*/

#ifndef _MYSTRINGMEMBER_H_
#define _MYSTRINGMEMBER_H_

using namespace std;

class MyStringMember
{
    // Stream Insertion & Extraction Operator Overloads
    friend ostream &operator<<(ostream &, const MyStringMember &);
    friend istream &operator>>(istream &, MyStringMember &);

private:
    // args
    char *str;      // pointer to the char array (string)

public:
    // Constructors / Destructor
    MyStringMember();                           // No-Args Default Constructor
    MyStringMember(const char *pStr);           // 1-arg Overload Constructor
    MyStringMember(const MyStringMember &);     // Copy Constructor
    MyStringMember(MyStringMember &&);          // Move Constructor
    ~MyStringMember();                          // Destructor

    // Operator Overloads
    MyStringMember &operator=(const MyStringMember &);          // Copy Assignment Operator Overload
    MyStringMember &operator=(MyStringMember &&);               // Move Assignment Operator Overload
    MyStringMember operator-() const;                           // Unary Minus Operator Overload
    MyStringMember operator++();                                // Pre-Increment Operator Overload
    MyStringMember operator++(int);                             // Post-Increment Operator Overload
    bool operator==(const MyStringMember &) const;              // Equal-To Operator Overload
    bool operator!=(const MyStringMember &) const;              // Not-Equal-To Operator Overload
    bool operator<(const MyStringMember &) const;               // Less-Than Operator Overload
    bool operator>(const MyStringMember &) const;               // Greater-Than Operator Overload
    MyStringMember operator+(const MyStringMember &) const;     // Addition Operator Overload
    MyStringMember operator+=(const MyStringMember &) const;    // Increased-By Operator Overload
    MyStringMember operator*(const int) const;                  // Multiplication Operator Overload
    MyStringMember operator*=(const int) const;                 // Multiplied-By Operator Overload

    // Getters
    const char *get_str() const;
    int get_length() const;

    // Other Methods
    void display() const;

};

# endif // _MYSTRINGMEMBER_H_