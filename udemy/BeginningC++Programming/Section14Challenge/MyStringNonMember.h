/**
* @file MyStringNonMember.h
* @author Nicholas Walker
* @date 03/02/2023
*
* @brief Declares and creates the "MyStringNonMember" class
*/

#ifndef _MYSTRINGNONMEMBER_H_
#define _MYSTRINGNONMEMBER_H_

using namespace std;

class MyStringNonMember
{
    // Stream Insertion & Extraction Operator Overloads
    friend ostream &operator<<(ostream &, const MyStringNonMember &);
    friend istream &operator>>(istream &, MyStringNonMember &);

    // Non-Member Operator Overload Functions
    friend MyStringNonMember operator-(const MyStringNonMember &);                              // Negation Operator Overload
    friend MyStringNonMember operator++(const MyStringNonMember &);                             // Pre-Increment Operator Overload
    friend MyStringNonMember operator++(const MyStringNonMember &, int);                        // Post-Increment Operator Overload
    friend bool operator==(const MyStringNonMember &, const MyStringNonMember &);               // Equal-To Operator Overload
    friend bool operator!=(const MyStringNonMember &, const MyStringNonMember &);               // Not-Equal-To Operator Overload       
    friend bool operator<(const MyStringNonMember &, const MyStringNonMember &);                // Less-Than Operator Overload
    friend bool operator>(const MyStringNonMember &, const MyStringNonMember &);                // Greater-Than Operator Overload
    friend MyStringNonMember operator+(const MyStringNonMember &, const MyStringNonMember &);   // Addition Operator Overload
    friend MyStringNonMember &operator+=(MyStringNonMember &, const MyStringNonMember &);       // Increased-By Operator Overload
    friend MyStringNonMember operator*(const MyStringNonMember &, const int);                   // Multiplication Operator Overload
    friend MyStringNonMember &operator*=(MyStringNonMember &, const int);                       // Multiplied-By Operator Overload

private:
    // args
    char *str;      // pointer to the char array (string)

public:
    // Constructors / Destructor
    MyStringNonMember();                                // No-Args Default Constructor
    MyStringNonMember(const char *pStr);                // 1-arg Overload Constructor
    MyStringNonMember(const MyStringNonMember &);       // Copy Constructor
    MyStringNonMember(MyStringNonMember &&);            // Move Constructor
    ~MyStringNonMember();                               // Destructor

    // Operator Overloads
    MyStringNonMember &operator=(const MyStringNonMember &);    // Copy Assignment Operator Overload
    MyStringNonMember &operator=(MyStringNonMember &&);         // Move Assignment Operator Overload

    // Getters
    const char *get_str() const;
    int get_length() const;

    // Other Methods
    void display() const;

};

# endif // _MYSTRINGNONMEMBER_H_