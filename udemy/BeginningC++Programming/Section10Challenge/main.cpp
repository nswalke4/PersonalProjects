/**
 * @file main.cpp
 * @author Nicholas Walker
 * @date 02/07/2023
 *
 * @brief Ask the user to enter a message and (d)encrypt the message using the 'key'
 */

#include <iostream>
#include <cctype>
#include <string>

using namespace std;

int main(int argc, char *argv[])
{
    string alphabet {"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"};
    string key {"XZNLWEBGJHQDYVTKFUOMPCIASRxznlwebgjhqdyvtkfuompciasr"};
    string message {};

    cout << "\nWelcome to the message cypher program!!\n";
    cout << "---------------------------------------\n\n";
    cout << "Please enter the message you would like encrypted:\n";
    getline(cin, message);

    cout << "\n\n....... got it, Message Received .......\n";

    // encrypt message
    cout << "\n...............Encrypting...............";
    for (size_t i = 0; i < message.size(); i++)
    {
        char c {message.at(i)};
        if (isalpha(c))
        {
            int index {static_cast<int>(alphabet.find(c))};
            message.at(i) = key.at(index);
        }
    }
    cout << "\n\nEncrypted Message:\n" << message;

    // decrypt message
    cout << "\n\n...............Decrypting...............";
    for (size_t i = 0; i < message.size(); i++)
    {
        char c {message.at(i)};
        if (isalpha(c))
        {
            int index {static_cast<int>(key.find(c))};
            message.at(i) = alphabet.at(index);
        }
    }
    cout << "\n\nDecrypted Message:\n" << message;
    return 0;
}
