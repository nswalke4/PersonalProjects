/**
 * @file main.cpp
 * @author Nicholas Walker
 * @date 03/02/2023
 *
 * @brief Runs the Operator Overload practice program
 */

#include <iostream>
#include "MyStringMember.h"
#include "MyStringNonMember.h"

using namespace std;

int main(int argc, char *argv[])
{
    cout << boolalpha << endl;
    cout << "Welcome to the Operator Overload Practice C++ Program!" << endl;
    cout << "------------------------------------------------------" << endl << endl;
    cout << "Starting with the \"Member\" Operator Overloads..." << endl;

    /*
    MyStringMember a {"frank"};
    MyStringMember b {"frank"};

    cout << (a==b) << endl;         // true
    cout << (a!=b) << endl;          // false
    
    b = "george";
    cout << (a==b) << endl;         // false
    cout << (a!=b) << endl;          // true
     cout << (a<b) << endl;          // true
    cout << (a>b) << endl;           // false
    
    MyStringMember s1 {"FRANK"};
    s1 = -s1;       
    cout << s1 << endl;               // frank              

    s1 = s1 + "*****";
    cout << s1 << endl;               // frank*****       
    
    s1 += "-----";                        // frank*****-----
    cout << s1 << endl;
    
    MyStringMember s2{"12345"};
    s1 = s2 * 3;
    cout << s1 << endl;              // 123451234512345
    
    MyStringMember s3{"abcdef"};  
    s3 *= 5;
    cout << s3 << endl;             // abcdefabcdefabcdefabcdefabcdef
    
    MyStringMember s = "Frank";
    ++s;
    cout << s << endl;                  // FRANK
    
    s = -s; 
    cout << s << endl;                  // frank
    
    MyStringMember result;
    result = ++s;                           
    cout << s << endl;                  // FRANK
    cout << result << endl;           // FRANK
    
    s = "Frank";
    s++;
    cout << s << endl;                  // FRANK
    
    s = -s;
    cout << s << endl;                  // frank
    result = s++;
    cout << s << endl;                  // FRANK
    cout << result << endl;           // frank
    
    */

   cout << endl << "------------------------------------------------------" << endl;
   cout << "------------------------------------------------------" << endl << endl;
   cout << "Now running with the \"Non-Member\" Operator Overloads..." << endl;

   /*
    MyStringNonMember a {"frank"};
    MyStringNonMember b {"frank"};

    cout << (a==b) << endl;         // true
    cout << (a!=b) << endl;          // false
    
    b = "george";
    cout << (a==b) << endl;         // false
    cout << (a!=b) << endl;          // true
     cout << (a<b) << endl;          // true
    cout << (a>b) << endl;           // false
    
    MyStringNonMember s1 {"FRANK"};
    s1 = -s1;       
    cout << s1 << endl;               // frank              

    s1 = s1 + "*****";
    cout << s1 << endl;               // frank*****       
    
    s1 += "-----";                        // frank*****-----
    cout << s1 << endl;
    
    MyStringNonMember s2{"12345"};
    s1 = s2 * 3;
    cout << s1 << endl;              // 123451234512345
    
    MyStringNonMember s3{"abcdef"};  
    s3 *= 5;
    cout << s3 << endl;             // abcdefabcdefabcdefabcdefabcdef
    
    MyStringNonMember s = "Frank";
    ++s;
    cout << s << endl;                  // FRANK
    
    s = -s; 
    cout << s << endl;                  // frank
    
    MyStringNonMember result;
    result = ++s;                           
    cout << s << endl;                  // FRANK
    cout << result << endl;           // FRANK
    
    s = "Frank";
    s++;
    cout << s << endl;                  // FRANK
    
    s = -s;
    cout << s << endl;                  // frank
    result = s++;
    cout << s << endl;                  // FRANK
    cout << result << endl;           // frank
    
    */

    return 0;
}
