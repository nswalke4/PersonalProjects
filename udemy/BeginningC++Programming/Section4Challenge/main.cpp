/*
 * @file main.cpp
 * @author Nicholas Walker
 * @date 02/04/2022
 *
 * @brief Collect and display a number from the console
 */

#include <iostream>

int main()
{
    int favNum;

    std::cout << "Enter your favorite number between 1 and 100:  ";
    std::cin >> favNum;
    std::cout << "Amazing!!  That's my favorite number too!\nNo really!!  "
        << favNum << " is my favorite number!" << std::endl;

    return 0;
}